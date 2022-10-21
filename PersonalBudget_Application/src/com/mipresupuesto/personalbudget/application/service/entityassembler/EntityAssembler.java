package com.mipresupuesto.personalbudget.application.service.entityassembler;

public interface EntityAssembler<E, D> {

	D assembleDomain(E entity);

	E assembleEntity(D domain);

}
