package com.mipresupuesto.personalbudget.domain;

public class BudgetDomain {
	
	private final YearDomain year;
	private final  PersonDomain person;
	
	private BudgetDomain( YearDomain year, PersonDomain person) {
		this.year = year;
		this.person = person;
	}
	
	public static BudgetDomain build( YearDomain year, PersonDomain person) {
		return new BudgetDomain(year, person);
	}

	public final YearDomain getYear() {
		return year;
	}

	public final PersonDomain getPerson() {
		return person;
	}
	
	
}
