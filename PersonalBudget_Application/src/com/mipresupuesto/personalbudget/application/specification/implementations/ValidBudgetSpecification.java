package com.mipresupuesto.personalbudget.application.specification.implementations;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mipresupuesto.personalbudget.application.specification.CompositeSpecification;
import com.mipresupuesto.personalbudget.crosscuting.exceptions.BudgetException;
import com.mipresupuesto.personalbudget.crosscuting.utils.UtilObject;
import com.mipresupuesto.personalbudget.crosscuting.utils.UtilUUID;
import com.mipresupuesto.personalbudget.domain.BudgetDomain;

@Component
public class ValidBudgetSpecification extends CompositeSpecification<BudgetDomain> {

	@Autowired
	BudgetIdIsValidSpecification idSpecification;
	@Autowired
	ValidPersonSpecification validPerson;
	@Autowired
	ValidYearSpecification validYear;
	@Autowired
	NotBudgetForTheSameYearSpecification notBudgetForTheSameYear;

	@Override
	public boolean isSatisfyBy(BudgetDomain object) {
		try {
			return isNotNullOrHasNoInfo(object) && idSpecification.isSatisfyBy(object)
					&& validPerson.isSatisfyBy(object.getPerson()) && validYear.isSatisfyBy(object.getYear())
					&& notBudgetForTheSameYear.isSatisfyBy(object);
		} catch (BudgetException exception) {
			throw exception;
		}
	}

	private boolean isNotNullOrHasNoInfo(BudgetDomain budget) {
		boolean defaultPerson;
		try {
			new PersonIsNotDefaultSpecification().isSatisfyBy(budget.getPerson());
			defaultPerson = false;
		} catch (BudgetException e) {
			defaultPerson = true;
		}
		boolean defaultYear;
		try {
			new YearIsNotDefaultSpecification().isSatisfyBy(budget.getYear());
			defaultYear = false;
		} catch (BudgetException e) {
			defaultYear = true;
		}
		boolean defaultID = Objects.equals(budget.getId().toString(), UtilUUID.DEFAULT_UUID_STRING);

		if (UtilObject.getUtilObject().isNull(budget) || (defaultPerson && defaultYear && defaultID)) {
			throw BudgetException.buildUserException("Provided budget hasn't info");
		}
		return true;
	}

}
