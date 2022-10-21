package com.mipresupuesto.personalbudget.application.command.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mipresupuesto.personalbudget.application.command.interfaces.createBudgetPort;
import com.mipresupuesto.personalbudget.application.service.dtoassembler.DTOAssembler;
import com.mipresupuesto.personalbudget.application.service.interfaces.CreateBudgetUseCase;
import com.mipresupuesto.personalbudget.domain.BudgetDomain;
import com.mipresupuesto.personalbudget.dto.BudgetDTO;

@Service
public class CreatBudgetCommand implements createBudgetPort {

	@Autowired
	private CreateBudgetUseCase useCase;
	@Autowired
	private DTOAssembler<BudgetDTO, BudgetDomain> dtoAssmebler;
	
	@Override
	public void execute(BudgetDTO budget) {
		useCase.execute(dtoAssmebler.assembleDomain(budget));
	}

}
