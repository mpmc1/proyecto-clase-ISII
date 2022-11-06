package com.mipresupuesto.personalbudget.controller;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mipresupuesto.personalbudget.application.command.interfaces.CreateBudgetPort;
import com.mipresupuesto.personalbudget.controller.response.Response;
import com.mipresupuesto.personalbudget.controller.response.dto.Message;
import com.mipresupuesto.personalbudget.crosscuting.exceptions.BudgetException;
import com.mipresupuesto.personalbudget.dto.BudgetDTO;

@RestController
@RequestMapping("api/v1/budget")

public class BudgetController {
	 @GetMapping("get")
	    public String home(Model model, @AuthenticationPrincipal OidcUser principal) {
	        if (principal != null) {
	            model.addAttribute("profile", principal.getClaims());
	        }
	        return "index";
	    }

	@Autowired
	private CreateBudgetPort createBudgetPort;
	
	
	
	
	
	
	@PostMapping("post")
	public ResponseEntity<Response<BudgetDTO>> createBudget(@RequestBody BudgetDTO budget) {
		Response<BudgetDTO> response = new Response<>();
		ResponseEntity<Response<BudgetDTO>> responseEntity;
		HttpStatus statusCode = HttpStatus.OK;
		response.setData(new ArrayList<>());
		try {
			createBudgetPort.execute(budget);
			response.addData(budget);
			response.addMessage(Message.createErrorMessage("Budget created Succesfully", "Budget created Succesfully"));
		}catch(BudgetException exception){
			statusCode = HttpStatus.BAD_REQUEST;
			response.addMessage(Message.createErrorMessage(exception.getMessage(),exception.getMessage()));
		}catch(Exception exception){
			response.addMessage(Message.createErrorMessage(exception.getMessage(),exception.getMessage()));
		}
		responseEntity = new ResponseEntity<Response<BudgetDTO>>(response, statusCode);
		return responseEntity;
	}
}

