package com.mipresupuesto.personalbudget.application.service.implementation;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mipresupuesto.personalbudget.application.service.entityassembler.EntityAssembler;
import com.mipresupuesto.personalbudget.application.service.interfaces.CreateBudgetUseCase;
import com.mipresupuesto.personalbudget.application.specification.implementations.ValidBudgetSpecification;
import com.mipresupuesto.personalbudget.crosscuting.exceptions.BudgetException;
import com.mipresupuesto.personalbudget.crosscuting.utils.UtilUUID;
import com.mipresupuesto.personalbudget.domain.BudgetDomain;
import com.mipresupuesto.personalbudget.entity.BudgetEntity;
import com.mipresupuesto.personalbudget.infraestructure.data.interfaces.BudgetRepository;

@Service
@Transactional
public class CreateBadgetUseCaseImpl implements CreateBudgetUseCase {

	@Autowired
	private EntityAssembler<BudgetEntity, BudgetDomain> entityAssembler;
	@Autowired
	private BudgetRepository budgetRepository;
	@Autowired
	ValidBudgetSpecification validBudgetSpecification;
	@Override
	public void execute(BudgetDomain budget) {
		try {
			BudgetEntity budgetEntity = entityAssembler.assembleEntity(budget);
			budgetEntity.setId(UtilUUID.getNewUUID());
			validBudgetSpecification.isSatisfyBy(budget);
			budgetRepository.createBudgetByPersonAndYear(budgetEntity.getId().toString(),budgetEntity.getYear().getId().toString(),budgetEntity.getPerson().getId().toString());			
		} catch (BudgetException exception) {
			throw exception;
		}catch (Exception e) {
			throw BudgetException.build("Error trying to create budget", e.getMessage());
		}

	}
	

}
