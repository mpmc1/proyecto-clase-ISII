package com.mipresupuesto.personalbudget.application.specification.implementations;

import java.time.Year;

import org.springframework.stereotype.Component;

import com.mipresupuesto.personalbudget.application.specification.CompositeSpecification;
import com.mipresupuesto.personalbudget.crosscuting.exceptions.BudgetException;
import com.mipresupuesto.personalbudget.crosscuting.utils.UtilNumeric;
import com.mipresupuesto.personalbudget.domain.YearDomain;

@Component
public class YearIsGreatherThanActualSpecification extends CompositeSpecification<YearDomain> {
	public boolean isSatisfyBy(YearDomain object) {
		try {
			return YearIsGreatherThanActual(object);
		} catch (BudgetException exception) {
			throw exception;
		}
	}
	
	private boolean YearIsGreatherThanActual(YearDomain year) {
		if (UtilNumeric.getUtilNumeric().isGreatherThan(year.getYear(), Year.now().getValue()))
			return true;
		else
			throw BudgetException.buildUserException("The given year has to be greather than actual");
	}

}
