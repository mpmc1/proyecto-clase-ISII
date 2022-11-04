package com.mipresupuesto.personalbudget.application.service.implementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.mipresupuesto.personalbudget.application.service.entityassembler.EntityAssembler;
import com.mipresupuesto.personalbudget.application.service.interfaces.GetYearUseCase;
import com.mipresupuesto.personalbudget.domain.YearDomain;
import com.mipresupuesto.personalbudget.entity.YearEntity;
import com.mipresupuesto.personalbudget.infraestructure.data.interfaces.YearRepository;

public class GetYearUseCaseImpl implements GetYearUseCase {
	@Autowired
	EntityAssembler<YearEntity, YearDomain> entityAssembler;
	@Autowired
	YearRepository yearRepository;
	
	
	@Override
	public YearDomain get(YearDomain year) {
		YearEntity yearEntity = entityAssembler.assembleEntity(year);
		Optional<YearEntity> response = yearRepository.findById(yearEntity.getId());
		if(response.isPresent()) {
			return entityAssembler.assembleDomain(response.get());
		}else {
			return null;
		}
	}
}
