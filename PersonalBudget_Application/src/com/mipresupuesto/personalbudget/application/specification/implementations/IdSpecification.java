package com.mipresupuesto.personalbudget.application.specification.implementations;

import java.util.UUID;

import com.mipresupuesto.personalbudget.application.specification.AndNotSpecification;
import com.mipresupuesto.personalbudget.application.specification.AndSpecification;
import com.mipresupuesto.personalbudget.application.specification.CompositeSpecification;
import com.mipresupuesto.personalbudget.application.specification.ISpecification;
import com.mipresupuesto.personalbudget.application.specification.NotSpecification;
import com.mipresupuesto.personalbudget.application.specification.OrNotSpecification;
import com.mipresupuesto.personalbudget.application.specification.OrSpecification;
import com.mipresupuesto.personalbudget.crosscuting.utils.UtilUUID;
import com.mipresupuesto.personalbudget.domain.YearDomain;

public class IdSpecification extends CompositeSpecification<UUID> {

	@Override
	public boolean isSatisfyBy(UUID object) {
		return idHasRequiredLength(object);
	}
	@Override
	public ISpecification<UUID> and(ISpecification<UUID> other) {
		return new AndSpecification<>(this, other);
	}
	@Override
	public ISpecification<UUID> or(ISpecification<UUID> other) {
		return new OrSpecification<>(this, other);
	}
	@Override
	public ISpecification<UUID> not(ISpecification<UUID> other) {
		return new NotSpecification<>(other);
	}
	@Override
	public ISpecification<UUID> andNot(ISpecification<UUID> other) {
		return new AndNotSpecification<>(this, other);
	}
	@Override
	public ISpecification<UUID> orNot(ISpecification<UUID> other) {
		return new OrNotSpecification<>(this, other);
	}
	private boolean idHasRequiredLength(UUID uuid){
		return UtilUUID.getStringFromUuid(uuid).length() == 36;
	}

}
