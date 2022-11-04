package com.mipresupuesto.personalbudget.application.specification.implementations;

import org.springframework.util.ObjectUtils;

import com.mipresupuesto.personalbudget.application.specification.AndNotSpecification;
import com.mipresupuesto.personalbudget.application.specification.AndSpecification;
import com.mipresupuesto.personalbudget.application.specification.CompositeSpecification;
import com.mipresupuesto.personalbudget.application.specification.ISpecification;
import com.mipresupuesto.personalbudget.application.specification.NotSpecification;
import com.mipresupuesto.personalbudget.application.specification.OrNotSpecification;
import com.mipresupuesto.personalbudget.application.specification.OrSpecification;
import com.mipresupuesto.personalbudget.crosscuting.utils.UtilObject;
import com.mipresupuesto.personalbudget.crosscuting.utils.UtilUUID;
import com.mipresupuesto.personalbudget.domain.PersonDomain;
import com.mipresupuesto.personalbudget.domain.YearDomain;

public class PersonSpecification extends CompositeSpecification<PersonDomain> {
	

	@Override
	public boolean isSatisfyBy(PersonDomain object) {
		return false;
	}

	@Override
	public ISpecification<PersonDomain> and(ISpecification<PersonDomain> other) {
		return super.and(other);
	}

	@Override
	public ISpecification<PersonDomain> andNot(ISpecification<PersonDomain> other) {
		return super.andNot(other);
	}
	@Override
	public ISpecification<PersonDomain> not(ISpecification<PersonDomain> other) {
		return super.not(other);
	}@Override
	public ISpecification<PersonDomain> or(ISpecification<PersonDomain> other) {
		return super.or(other);
	}
	@Override
	public ISpecification<PersonDomain> orNot(ISpecification<PersonDomain> other) {
		return super.orNot(other);
	}

	private boolean isNotNull(PersonDomain person) {
		return UtilObject.getUtilObject().isNull(person);
	}

	private boolean mandatoryValuesAreNotNull(PersonDomain person) {
		return UtilObject.getUtilObject().isNull(person.getIdCard())
				&& UtilObject.getUtilObject().isNull(person.getFirstName())
				&& UtilObject.getUtilObject().isNull(person.getMiddleName())
				&& UtilObject.getUtilObject().isNull(person.getLastName());
	}

}