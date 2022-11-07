package com.mipresupuesto.personalbudget.application.specification.implementations;

import java.util.Objects;

import org.springframework.stereotype.Component;

import com.mipresupuesto.personalbudget.application.specification.CompositeSpecification;
import com.mipresupuesto.personalbudget.crosscuting.exceptions.BudgetException;
import com.mipresupuesto.personalbudget.crosscuting.utils.UtilObject;
import com.mipresupuesto.personalbudget.crosscuting.utils.UtilUUID;
import com.mipresupuesto.personalbudget.domain.BudgetDomain;

@Component
public class BudgetIdIsValidSpecification extends CompositeSpecification<BudgetDomain>{

	@Override
	public boolean isSatisfyBy(BudgetDomain object) {
		return isValidId(object);
	}
	
	private boolean isValidId(BudgetDomain budget) {
		if (UtilObject.getUtilObject().isNull(budget.getId())) {
			throw BudgetException.buildUserException("Year id cant be null");
		}
		if (UtilUUID.getStringFromUuid(budget.getId()).length() != 36|| Objects.equals(budget.getId().toString(), UtilUUID.DEFAULT_UUID_STRING)) {
			throw BudgetException.buildUserException("Invalid budget Id");
		}
		return true;

	}

}
