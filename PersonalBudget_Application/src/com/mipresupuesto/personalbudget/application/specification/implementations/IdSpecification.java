package com.mipresupuesto.personalbudget.application.specification.implementations;

import java.util.UUID;

import com.mipresupuesto.personalbudget.application.specification.AndNotSpecification;
import com.mipresupuesto.personalbudget.application.specification.AndSpecification;
import com.mipresupuesto.personalbudget.application.specification.CompositeSpecification;
import com.mipresupuesto.personalbudget.application.specification.ISpecification;
import com.mipresupuesto.personalbudget.application.specification.NotSpecification;
import com.mipresupuesto.personalbudget.application.specification.OrNotSpecification;
import com.mipresupuesto.personalbudget.application.specification.OrSpecification;
import com.mipresupuesto.personalbudget.crosscuting.utils.UtilObject;
import com.mipresupuesto.personalbudget.crosscuting.utils.UtilUUID;
import com.mipresupuesto.personalbudget.domain.YearDomain;

public class IdSpecification extends CompositeSpecification<UUID> {

	@Override
	public boolean isSatisfyBy(UUID object) {
		return idHasRequiredLength(object) && isNotNull(object);
	}
	private boolean idHasRequiredLength(UUID uuid){
		return UtilUUID.getStringFromUuid(uuid).length() == 36;
	}
	private boolean isNotNull(UUID uuid) {
		return !UtilObject.getUtilObject().isNull(uuid);
	}

}
