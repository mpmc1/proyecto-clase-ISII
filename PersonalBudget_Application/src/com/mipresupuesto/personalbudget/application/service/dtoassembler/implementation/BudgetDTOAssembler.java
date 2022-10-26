package com.mipresupuesto.personalbudget.application.service.dtoassembler.implementation;

import org.springframework.stereotype.Component;
import com.mipresupuesto.personalbudget.application.service.dtoassembler.DTOAssembler;
import com.mipresupuesto.personalbudget.crosscuting.utils.UtilUUID;
import com.mipresupuesto.personalbudget.domain.BudgetDomain;
import com.mipresupuesto.personalbudget.domain.build.BudgetDomainBuilder;
import com.mipresupuesto.personalbudget.domain.build.YearDomainBuilder;
import com.mipresupuesto.personalbudget.dto.BudgetDTO;

@Component
public final class BudgetDTOAssembler implements DTOAssembler<BudgetDTO, BudgetDomain> {

	PersonDTOAssembler personAssembler = new PersonDTOAssembler();
	YearDTOAssembler yearAssembler = new YearDTOAssembler();

	@Override
	public BudgetDomain assembleDomain(final BudgetDTO dto) {
		BudgetDomain domain = BudgetDomainBuilder.get().build();
		if (dto != null) {
			domain = BudgetDomainBuilder.get().setPerson(personAssembler.assembleDomain(dto.getPerson()))
					.setYear(yearAssembler.assembleDomain(dto.getYear())).build();
		}
		return domain;
	}

	@Override
	public BudgetDTO assembleDTO(BudgetDomain domain) {
		BudgetDTO budgetDto = new BudgetDTO();
		if (domain != null) {
			budgetDto = new BudgetDTO(yearAssembler.assembleDTO(domain.getYear()),
					personAssembler.assembleDTO(domain.getPerson()));
		}
		return budgetDto;
	}

}
