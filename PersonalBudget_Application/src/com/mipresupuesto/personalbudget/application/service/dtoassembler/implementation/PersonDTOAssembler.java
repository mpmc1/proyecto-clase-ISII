package com.mipresupuesto.personalbudget.application.service.dtoassembler.implementation;



import org.springframework.stereotype.Component;

import com.mipresupuesto.personalbudget.application.service.dtoassembler.DTOAssembler;
import com.mipresupuesto.personalbudget.crosscuting.utils.UtilObject;
import com.mipresupuesto.personalbudget.crosscuting.utils.UtilUUID;
import com.mipresupuesto.personalbudget.domain.PersonDomain;
import com.mipresupuesto.personalbudget.domain.build.PersonDomainBuilder;
import com.mipresupuesto.personalbudget.dto.PersonDTO;

@Component
public class PersonDTOAssembler implements DTOAssembler<PersonDTO, PersonDomain> {

	@Override
	public PersonDomain assembleDomain(final PersonDTO dto) {
		PersonDomain domain = PersonDomainBuilder.get().build();
		if (!UtilObject.getUtilObject().isNull(dto)) {
			domain = PersonDomainBuilder.get().setId(UtilUUID.getUuidFromString(dto.getId()))
					.setFirstName(dto.getFirstName()).setIdCard(dto.getIdCard()).setLastName(dto.getLastName())
					.setMiddleName(dto.getMiddleName()).build();
		}
		return domain;
	}

	@Override
	public PersonDTO assembleDTO(PersonDomain domain) {
		PersonDTO personDto = new PersonDTO();
		if (!UtilObject.getUtilObject().isNull(domain)) {
			personDto = new PersonDTO(UtilUUID.getStringFromUuid(domain.getId()), domain.getIdCard(),
					domain.getFirstName(), domain.getMiddleName(), domain.getLastName(), domain.getName(),
					domain.getCompleteName());
		}
		return personDto;
	}

}
