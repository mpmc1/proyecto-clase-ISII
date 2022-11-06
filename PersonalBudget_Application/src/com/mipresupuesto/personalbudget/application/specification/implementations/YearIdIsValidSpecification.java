package com.mipresupuesto.personalbudget.application.specification.implementations;

import java.util.Objects;

import org.springframework.stereotype.Component;

import com.mipresupuesto.personalbudget.application.specification.CompositeSpecification;
import com.mipresupuesto.personalbudget.crosscuting.exceptions.BudgetException;
import com.mipresupuesto.personalbudget.crosscuting.utils.UtilObject;
import com.mipresupuesto.personalbudget.crosscuting.utils.UtilUUID;
import com.mipresupuesto.personalbudget.domain.PersonDomain;
import com.mipresupuesto.personalbudget.domain.YearDomain;

@Component
public class YearIdIsValidSpecification extends CompositeSpecification<YearDomain>{
	
	public boolean isSatisfyBy(YearDomain object) {
		try {
			return isValidId(object);
		} catch (BudgetException exception) {
			throw exception;
		}
	}
	
	private boolean isValidId(YearDomain year) {
		if (UtilObject.getUtilObject().isNull(year.getId())) {
			throw BudgetException.buildUserException("Year id cant be null");
		}
		if (UtilUUID.getStringFromUuid(year.getId()).length() != 36|| Objects.equals(year.getId().toString(), UtilUUID.DEFAULT_UUID_STRING)) {
			throw BudgetException.buildUserException("Invalid year Id");
		}
		return true;

	}

}
