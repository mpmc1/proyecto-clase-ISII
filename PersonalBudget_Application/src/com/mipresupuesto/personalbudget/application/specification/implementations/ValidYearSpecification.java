package com.mipresupuesto.personalbudget.application.specification.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mipresupuesto.personalbudget.application.specification.CompositeSpecification;
import com.mipresupuesto.personalbudget.crosscuting.exceptions.BudgetException;
import com.mipresupuesto.personalbudget.domain.YearDomain;

@Component
public class ValidYearSpecification extends CompositeSpecification<YearDomain>{

	@Autowired
	YearIsNotDefaultSpecification yearIsNotDefault;
	@Autowired
	YearIdIsValidSpecification yearIdIsValid;
	@Autowired
	YearIsGreatherThanActualSpecification yearIsGreatherThanActual;
	@Autowired
	YearExistSpecification yearExist;
	
	@Override
	public boolean isSatisfyBy(YearDomain object) {
		try {
			return yearIsNotDefault.and(yearIdIsValid).and(yearIsGreatherThanActual).and(yearExist).isSatisfyBy(object);			
		} catch (BudgetException e) {
			throw e;
		}
	}

}
