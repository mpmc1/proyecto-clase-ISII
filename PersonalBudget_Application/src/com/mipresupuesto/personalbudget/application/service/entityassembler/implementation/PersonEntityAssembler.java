package com.mipresupuesto.personalbudget.application.service.entityassembler.implementation;

import org.springframework.stereotype.Component;

import com.mipresupuesto.personalbudget.application.service.entityassembler.EntityAssembler;
import com.mipresupuesto.personalbudget.domain.PersonDomain;
import com.mipresupuesto.personalbudget.domain.YearDomain;
import com.mipresupuesto.personalbudget.domain.build.PersonDomainBuilder;
import com.mipresupuesto.personalbudget.domain.build.YearDomainBuilder;
import com.mipresupuesto.personalbudget.entity.PersonEntity;
import com.mipresupuesto.personalbudget.entity.YearEntity;

@Component
public class PersonEntityAssembler implements EntityAssembler<PersonEntity, PersonDomain> {

	@Override
	public PersonDomain assembleDomain(PersonEntity entity) {
		PersonDomain domain = PersonDomainBuilder.get().build();
		if (entity != null) {
			domain = PersonDomainBuilder.get().setId(entity.getId()).setFirstName(entity.getFirstName())
					.setLastName(entity.getLastName()).setIdCard(entity.getIdCard())
					.setMiddleName(entity.getMiddleName()).build();
		}
		return domain;
	}

	@Override
	public PersonEntity assembleEntity(PersonDomain domain) {
		PersonEntity entity = new PersonEntity();
		if (domain != null) {
			entity = new PersonEntity(domain.getId(), domain.getIdCard(), domain.getFirstName(), domain.getMiddleName(),
					domain.getLastName());
		}
		return entity;
	}

}
