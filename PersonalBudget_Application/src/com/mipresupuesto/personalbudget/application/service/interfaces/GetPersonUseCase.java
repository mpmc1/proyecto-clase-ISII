package com.mipresupuesto.personalbudget.application.service.interfaces;

import com.mipresupuesto.personalbudget.domain.PersonDomain;

public interface GetPersonUseCase {
	PersonDomain get(PersonDomain person);
}
