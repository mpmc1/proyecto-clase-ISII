package com.mipresupuesto.personalbudget.application.service.dtoassembler.implementation;

import org.springframework.stereotype.Component;
import com.mipresupuesto.personalbudget.application.service.dtoassembler.DTOAssembler;
import com.mipresupuesto.personalbudget.crosscuting.exceptions.BudgetException;
import com.mipresupuesto.personalbudget.crosscuting.utils.UtilObject;
import com.mipresupuesto.personalbudget.crosscuting.utils.UtilUUID;
import com.mipresupuesto.personalbudget.domain.BudgetDomain;
import com.mipresupuesto.personalbudget.domain.build.BudgetDomainBuilder;
import com.mipresupuesto.personalbudget.dto.BudgetDTO;

@Component
public final class BudgetDTOAssembler implements DTOAssembler<BudgetDTO, BudgetDomain> {

	PersonDTOAssembler personAssembler = new PersonDTOAssembler();
	YearDTOAssembler yearAssembler = new YearDTOAssembler();

	@Override
	public BudgetDomain assembleDomain(final BudgetDTO dto) {
		BudgetDomain domain = BudgetDomainBuilder.get().build();
		if (!UtilObject.getUtilObject().isNull(dto)) {
			domain = BudgetDomainBuilder.get().setPerson(personAssembler.assembleDomain(dto.getPerson()))
					.setYear(yearAssembler.assembleDomain(dto.getYear())).setId(UtilUUID.getUuidFromString(dto.getId()))
					.build();
		}
		return domain;
	}

	@Override
	public BudgetDTO assembleDTO(BudgetDomain domain) {
		BudgetDTO budgetDto = new BudgetDTO();
		if (!UtilObject.getUtilObject().isNull(domain)) {
			budgetDto = new BudgetDTO(UtilUUID.getStringFromUuid(domain.getId()),yearAssembler.assembleDTO(domain.getYear()),
					personAssembler.assembleDTO(domain.getPerson()));
		}
		return budgetDto;
	}

}
