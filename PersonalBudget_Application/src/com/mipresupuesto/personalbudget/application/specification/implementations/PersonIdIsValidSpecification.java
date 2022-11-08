package com.mipresupuesto.personalbudget.application.specification.implementations;

import java.util.Objects;

import org.springframework.stereotype.Component;

import com.mipresupuesto.personalbudget.application.specification.CompositeSpecification;
import com.mipresupuesto.personalbudget.crosscuting.exceptions.BudgetException;
import com.mipresupuesto.personalbudget.crosscuting.utils.UtilObject;
import com.mipresupuesto.personalbudget.crosscuting.utils.UtilUUID;
import com.mipresupuesto.personalbudget.domain.PersonDomain;

@Component
public class PersonIdIsValidSpecification extends CompositeSpecification<PersonDomain>{
	public boolean isSatisfyBy(PersonDomain object) {
		try {
			return isValidId(object);
		} catch (BudgetException exception) {
			throw exception;
		}
	}
	
	private boolean isValidId(PersonDomain person) {
		if (UtilObject.getUtilObject().isNull(person.getId())) {
			throw BudgetException.buildUserException("Person id cant be null");
		}
		if (UtilUUID.getStringFromUuid(person.getId()).length() != 36 || Objects.equals(person.getId().toString(), UtilUUID.DEFAULT_UUID_STRING)) {
			throw BudgetException.buildUserException("Invalid person Id");
		}
		return true;

	}

}
