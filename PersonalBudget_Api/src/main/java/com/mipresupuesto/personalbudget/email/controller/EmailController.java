/*
package com.mipresupuesto.personalbudget.email.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mipresupuesto.personalbudget.email.service.EmailService;



@RestController
@RequestMapping(value = "/api")
public class EmailController {

	@Autowired
	EmailService mailService;
	
	@PostMapping("/send-text")
	public String send() throws IOException {
		return mailService.sendTextEmail();
	}
	

}*/