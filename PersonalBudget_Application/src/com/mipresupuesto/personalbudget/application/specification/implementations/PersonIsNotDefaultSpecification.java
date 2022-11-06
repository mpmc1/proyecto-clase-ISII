package com.mipresupuesto.personalbudget.application.specification.implementations;

import org.springframework.stereotype.Component;

import com.mipresupuesto.personalbudget.application.specification.CompositeSpecification;
import com.mipresupuesto.personalbudget.crosscuting.exceptions.BudgetException;
import com.mipresupuesto.personalbudget.crosscuting.utils.UtilUUID;
import com.mipresupuesto.personalbudget.domain.PersonDomain;
import com.mipresupuesto.personalbudget.domain.build.PersonDomainBuilder;
import java.util.Objects;

@Component
public class PersonIsNotDefaultSpecification extends CompositeSpecification<PersonDomain>{
	public boolean isSatisfyBy(PersonDomain object) {
		try {
			return isNotDefault(object);
		} catch (BudgetException exception) {
			throw exception;
		}
	}
	private boolean isNotDefault(PersonDomain person) {
		if(Objects.equals(person.getId().toString(), UtilUUID.DEFAULT_UUID_STRING) && "".equals(person.getFirstName()) && "".equals(person.getLastName())) {
			throw BudgetException.buildUserException("Provided person has no info");
		}else return true;
	}
}
