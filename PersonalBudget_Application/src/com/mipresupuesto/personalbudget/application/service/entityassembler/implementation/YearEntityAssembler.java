package com.mipresupuesto.personalbudget.application.service.entityassembler.implementation;

import org.springframework.stereotype.Component;

import com.mipresupuesto.personalbudget.application.service.entityassembler.EntityAssembler;
import com.mipresupuesto.personalbudget.crosscuting.utils.UtilObject;
import com.mipresupuesto.personalbudget.domain.YearDomain;
import com.mipresupuesto.personalbudget.domain.build.YearDomainBuilder;
import com.mipresupuesto.personalbudget.entity.YearEntity;

@Component
public class YearEntityAssembler implements EntityAssembler<YearEntity, YearDomain> {

	@Override
	public YearDomain assembleDomain(YearEntity entity) {
		YearDomain domain = YearDomainBuilder.get().build();
		if(!UtilObject.getUtilObject().isNull(entity)) {
			domain = YearDomainBuilder.get().setId(entity.getId()).setYear(entity.getYear()).build();
		}
		return domain;
	}

	@Override
	public YearEntity assembleEntity(YearDomain domain) {
		YearEntity entity = new YearEntity();
		if(!UtilObject.getUtilObject().isNull(domain)) {
			entity = new YearEntity(domain.getId(), domain.getYear());
		}
		return entity;
	}

}
