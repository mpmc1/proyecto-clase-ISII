package com.mipresupuesto.personalbudget.application.command.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mipresupuesto.personalbudget.application.command.interfaces.CreateBudgetPort;
import com.mipresupuesto.personalbudget.application.service.dtoassembler.DTOAssembler;
import com.mipresupuesto.personalbudget.application.service.interfaces.CreateBudgetUseCase;
import com.mipresupuesto.personalbudget.crosscuting.exceptions.BudgetException;
import com.mipresupuesto.personalbudget.domain.BudgetDomain;
import com.mipresupuesto.personalbudget.dto.BudgetDTO;

@Service
public class CreateBudgetCommand implements CreateBudgetPort {

	@Autowired
	private CreateBudgetUseCase useCase;
	@Autowired
	private DTOAssembler<BudgetDTO, BudgetDomain> dtoAssmebler;
	
	@Override
	public void execute(BudgetDTO budget) {
		try {
			useCase.execute(dtoAssmebler.assembleDomain(budget));			
		} catch (BudgetException exception) {
			throw exception;
		}
	}

}
