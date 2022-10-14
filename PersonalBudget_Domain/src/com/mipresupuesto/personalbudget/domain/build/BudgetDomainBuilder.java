package com.mipresupuesto.personalbudget.domain.build;

import java.util.UUID;

import com.mipresupuesto.personalbudget.domain.BudgetDomain;
import com.mipresupuesto.personalbudget.domain.PersonDomain;
import com.mipresupuesto.personalbudget.domain.YearDomain;

public class BudgetDomainBuilder {

	private UUID id;
	private YearDomain year;
	private PersonDomain person;

	private BudgetDomainBuilder() {
		setId(UUID.randomUUID());
		setPerson(PersonDomainBuilder.get().build());
		setYear(YearDomainBuilder.get().build());
	}

	public static final BudgetDomainBuilder get() {
		return new BudgetDomainBuilder();
	}

	private YearDomain getYear() {
		return year;
	}

	public BudgetDomainBuilder setYear(YearDomain year) {
		this.year = year == null ? YearDomainBuilder.get().build() : year;
		return this;
	}

	private PersonDomain getPerson() {
		return person;
	}

	public BudgetDomainBuilder setPerson(PersonDomain person) {
		this.person = person == null ? PersonDomainBuilder.get().build() : person;
		return this;
	}
	public BudgetDomain build() {
		return BudgetDomain.build(getId(),getYear(),getPerson());
	}

	public final BudgetDomainBuilder setId(UUID id) {
		this.id = (id == null) ? UUID.randomUUID() : id;
		return this;
	}

	public final UUID getId() {
		return id;
	}
	

}
