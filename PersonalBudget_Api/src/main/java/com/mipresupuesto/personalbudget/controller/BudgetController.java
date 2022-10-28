package com.mipresupuesto.personalbudget.controller;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mipresupuesto.personalbudget.application.command.interfaces.CreateBudgetPort;
import com.mipresupuesto.personalbudget.controller.response.Response;
import com.mipresupuesto.personalbudget.crosscuting.exceptions.BudgetException;
import com.mipresupuesto.personalbudget.dto.BudgetDTO;

@RestController
@RequestMapping("api/v1/budget")
public class BudgetController {
	
	@Autowired
	private CreateBudgetPort createBudgetPort;
	
	@PostMapping
	public ResponseEntity<Response<BudgetDTO>> createBudget(@RequestBody BudgetDTO budget) {
		Response<BudgetDTO> response = new Response<>();
		ResponseEntity<Response<BudgetDTO>> responseEntity;
		HttpStatus statusCode = HttpStatus.BAD_REQUEST;
		response.setData(new ArrayList<>());
		ArrayList<String> messages = new ArrayList<>();
		try {
			createBudgetPort.execute(budget);
			response.addData(budget);
			statusCode = HttpStatus.OK;
			messages.add("Budget created Succesfully");
		}catch(BudgetException exception){
			messages.add(exception.getMessage());
		}catch(Exception exception){
			messages.add(exception.getMessage());
		}
		response.setMessages(messages);
		responseEntity = new ResponseEntity<Response<BudgetDTO>>(response, statusCode);
		return responseEntity;
	}
}
