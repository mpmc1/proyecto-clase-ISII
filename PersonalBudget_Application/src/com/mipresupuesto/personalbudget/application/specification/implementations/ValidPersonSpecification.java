package com.mipresupuesto.personalbudget.application.specification.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mipresupuesto.personalbudget.application.specification.CompositeSpecification;
import com.mipresupuesto.personalbudget.domain.PersonDomain;

@Component
public class ValidPersonSpecification extends CompositeSpecification<PersonDomain>{

	@Autowired
	PersonIdIsValidSpecification personIdIsValid;
	@Autowired
	PersonIsNotDefaultSpecification personIsNotDefault;
	@Autowired
	PersonMandatoryValuesAreNotNullSpecification personMandatoryValuesAreNotNull;
	@Autowired
	PersonExistSpecification personExist;
	
	@Override
	public boolean isSatisfyBy(PersonDomain object) {
		return personIsNotDefault.and(personIdIsValid).and(personExist).and(personMandatoryValuesAreNotNull).isSatisfyBy(object);
	}

}
