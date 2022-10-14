package com.mipresupuesto.personalbudget.domain;

import java.util.UUID;

public class BudgetDomain {

	private UUID id;
	private YearDomain year;
	private PersonDomain person;

	private BudgetDomain(final UUID id, final YearDomain year, final PersonDomain person) {
		this.id = id;
		this.year = year;
		this.person = person;
	}

	public static BudgetDomain build(final UUID id, final YearDomain year, final PersonDomain person) {
		return new BudgetDomain(id, year, person);
	}

	public final YearDomain getYear() {
		return year;
	}

	public final PersonDomain getPerson() {
		return person;
	}

	public final UUID getID() {
		return id;
	}

	public final void setId(final UUID id) {
		this.id = (id == null) ? UUID.randomUUID() : id;
	}

	public final void setYear(final YearDomain year) {
		this.year = year;
	}

	public final void setPerson(PersonDomain person) {
		this.person = person;
	}

}
