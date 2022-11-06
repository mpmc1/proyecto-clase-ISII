package com.mipresupuesto.personalbudget.application.specification.implementations;

import java.util.Objects;

import org.springframework.stereotype.Component;

import com.mipresupuesto.personalbudget.application.specification.CompositeSpecification;
import com.mipresupuesto.personalbudget.crosscuting.exceptions.BudgetException;
import com.mipresupuesto.personalbudget.crosscuting.utils.UtilObject;
import com.mipresupuesto.personalbudget.crosscuting.utils.UtilUUID;
import com.mipresupuesto.personalbudget.domain.YearDomain;
import com.mipresupuesto.personalbudget.domain.build.YearDomainBuilder;

@Component
public class YearIsNotDefaultSpecification extends CompositeSpecification<YearDomain> {

	public boolean isSatisfyBy(YearDomain object) {
		try {
			return isNotDefault(object);
		} catch (BudgetException exception) {
			throw exception;
		}
	}

	private boolean isNotDefault(YearDomain year) {
		if (Objects.equals(year.getId().toString(), UtilUUID.DEFAULT_UUID_STRING) && 0 == year.getYear())
			throw BudgetException.buildUserException("Provided year has not info");
		else
			return true;
	}

}
