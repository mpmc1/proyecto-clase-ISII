package com.mipresupuesto.personalbudget.application.service.dtoassembler.implementation;

import org.springframework.stereotype.Component;

import com.mipresupuesto.personalbudget.application.service.dtoassembler.DTOAssembler;
import com.mipresupuesto.personalbudget.crosscuting.utils.UtilUUID;
import com.mipresupuesto.personalbudget.domain.YearDomain;
import com.mipresupuesto.personalbudget.domain.build.YearDomainBuilder;
import com.mipresupuesto.personalbudget.dto.YearDTO;

@Component
public final class YearDTOAssembler implements DTOAssembler<YearDTO, YearDomain> {

	@Override
	public YearDomain assembleDomain(final YearDTO dto) {
		YearDomain domain = YearDomainBuilder.get().build();
		if (dto != null) {
			domain = YearDomainBuilder.get().setId(UtilUUID.getUuidFromString(dto.getId())).setYear(dto.getYear())
					.build();
		}
		return domain;
	}

	@Override
	public YearDTO assembleDTO(YearDomain domain) {
		YearDTO yearDto = new YearDTO();
		if (domain != null) {
			yearDto = new YearDTO(UtilUUID.getStringFromUuid(domain.getId()), domain.getYear());
		}
		return yearDto;
	}
	// TODO: JPA with hibernate and spring 

}
