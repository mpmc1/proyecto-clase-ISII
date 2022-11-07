package com.mipresupuesto.personalbudget.application.specification.implementations;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mipresupuesto.personalbudget.application.specification.CompositeSpecification;
import com.mipresupuesto.personalbudget.crosscuting.exceptions.BudgetException;
import com.mipresupuesto.personalbudget.domain.BudgetDomain;
import com.mipresupuesto.personalbudget.entity.BudgetEntity;
import com.mipresupuesto.personalbudget.infraestructure.data.interfaces.BudgetRepository;

@Service
public class NotBudgetForTheSameYearSpecification extends CompositeSpecification<BudgetDomain> {

	@Autowired
	BudgetRepository budgetRepository;

	@Override
	public boolean isSatisfyBy(BudgetDomain object) {
		return !existBudget(object);
	}

	private boolean existBudget(BudgetDomain budget) {
		try {
			Optional<BudgetEntity> response = budgetRepository.findBudgetByPersonAndYear(budget.getPerson().getId().toString(),
					budget.getYear().getId().toString());
			if (response.isPresent()) {
				throw BudgetException.buildUserException("The given user already has a budget for the provided year");
			}
			return false;
		}catch(BudgetException budgetException){
			throw budgetException;
		} catch (Exception e) {
			throw BudgetException.build("Error trying to get budget information", e.getMessage());
		}
	}

}
