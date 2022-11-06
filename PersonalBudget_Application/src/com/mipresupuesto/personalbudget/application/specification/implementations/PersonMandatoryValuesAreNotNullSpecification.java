package com.mipresupuesto.personalbudget.application.specification.implementations;

import org.springframework.stereotype.Component;

import com.mipresupuesto.personalbudget.application.specification.CompositeSpecification;
import com.mipresupuesto.personalbudget.crosscuting.exceptions.BudgetException;
import com.mipresupuesto.personalbudget.domain.PersonDomain;

@Component
public class PersonMandatoryValuesAreNotNullSpecification extends CompositeSpecification<PersonDomain> {

	public boolean isSatisfyBy(PersonDomain object) {
		try {
			return mandatoryValuesAreNotNull(object);
		} catch (BudgetException exception) {
			throw exception;
		}
	}

	private boolean mandatoryValuesAreNotNull(PersonDomain person) {
		if (person.getFirstName() == null || "".equals(person.getFirstName())) {
			throw BudgetException.buildUserException("User first name is a mandatory information");
		}
		if (person.getMiddleName() == null) {
			throw BudgetException.buildUserException("User middlename can't be null");
		}
		if (person.getIdCard() == null || "".equals(person.getIdCard())) {
			throw BudgetException.buildUserException("Id card is a mandatory information");
		}
		if (person.getLastName() == null || "".equals(person.getLastName())) {
			throw BudgetException.buildUserException("User lastname is a mandatory information");
		}
		return true;
	}

}
