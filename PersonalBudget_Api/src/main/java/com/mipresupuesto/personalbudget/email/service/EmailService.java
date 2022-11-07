package com.mipresupuesto.personalbudget.email.service;

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

@Service
public class EmailService {
	private static final Logger logger = LoggerFactory.getLogger(EmailService.class);
	
	public String sendTextEmail() throws IOException {
		// the sender email should be the same as we used to Create a Single Sender Verification
		    Email from = new Email("juanjo_cg08@outlook.com");
		    String subject = "The subject";
		    Email to = new Email("juancho.carmona.13@gmail.com");
		    Content content = new Content("text/plain", "This is a test email");
		    Mail mail = new Mail(from, subject, to, content);
		
		    SendGrid sg = new SendGrid("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");
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
