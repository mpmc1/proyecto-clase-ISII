package com.mipresupuesto.personalbudget.entity;

import java.util.UUID;

public class BudgetEntity {
	private UUID id;
	private YearEntity year;
	private PersonEntity person;

	public BudgetEntity() {
		setPerson(new PersonEntity());
		setYear(new YearEntity());
	}

	public BudgetEntity(final YearEntity year, final PersonEntity person) {
		setPerson(person);
		setYear(year);
	}

	public PersonEntity getPerson() {
		if(person == null) {
			setPerson(new PersonEntity());
		}
		return person;
	}

	public final void setPerson(final PersonEntity person) {
		this.person = person;
	}

	public final YearEntity getYear() {
		if(year == null) {
			setYear(new YearEntity());
		}
		return year;
	}

	public final void setYear(final YearEntity year) {
		this.year = year;
	}

	public final UUID getId() {
		
		return id;
	}

	public final void setId(UUID id) {
		this.id = id;
	}

}
