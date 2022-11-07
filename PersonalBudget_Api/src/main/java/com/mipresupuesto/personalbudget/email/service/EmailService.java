package com.mipresupuesto.personalbudget.email.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;


@Configuration
@Service
public class EmailService {
	private static final Logger logger = LoggerFactory.getLogger(EmailService.class);
	
	@Value("${spring.sendgrid.api-key}")
	private String key;
    
	public String sendTextEmail() throws IOException {
		    Email from = new Email("juanjo_cg08@outlook.com");
		    String subject = "Prueba 86";
		    Email to = new Email("juancho.carmona.13@gmail.com");
		    Content content = new Content("text/plain", "Goliamos");
		    Mail
		    mail = new Mail(from, subject, to, content);
		    
		    
		    
		    SendGrid sg = new SendGrid(key);
		    Request request = new Request();
		    try {
		      request.setMethod(Method.POST);
		      request.setEndpoint("mail/send");
		      request.setBody(mail.build());
		      Response response = sg.api(request);
		      logger.info(response.getBody());
		      return response.getBody();	     
		    } catch (IOException ex) {
		      throw ex;
		    }	   
	}
}
