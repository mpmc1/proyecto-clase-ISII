package com.mipresupuesto.personalbudget.application.service.dtoassembler.implementation;

import org.springframework.stereotype.Component;

import com.mipresupuesto.personalbudget.application.service.dtoassembler.DTOAssembler;
import com.mipresupuesto.personalbudget.crosscuting.utils.UtilUUID;
import com.mipresupuesto.personalbudget.domain.BudgetDomain;
import com.mipresupuesto.personalbudget.domain.YearDomain;
import com.mipresupuesto.personalbudget.domain.build.BudgetDomainBuilder;
import com.mipresupuesto.personalbudget.domain.build.YearDomainBuilder;
import com.mipresupuesto.personalbudget.dto.BudgetDTO;
import com.mipresupuesto.personalbudget.dto.YearDTO;

@Component
public final class BudgetDTOAssembler implements DTOAssembler<BudgetDTO, BudgetDomain> {

	@Override
	public BudgetDomain assembleDomain(final BudgetDTO dto) {
		BudgetDomain domain = BudgetDomainBuilder.get().build();
		if (dto != null) {
			domain = BudgetDomainBuilder.get()
					.build();
		}
		return domain;
	}

	@Override
	public BudgetDTO assembleDTO(BudgetDomain domain) {
		BudgetDTO budgetDto = new BudgetDTO();
		if (domain != null) {
			budgetDto = new BudgetDTO();
		}
		return budgetDto;
	}
	//TODO: Entity Assemblers, finish DTO Assemblers, entities with annotations, JPA with hibernate and spring 

}
