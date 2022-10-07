package com.mipresupuesto.personalbudget.domain.build;

import com.mipresupuesto.personalbudget.domain.PersonDomain;
import com.mipresupuesto.personalbudget.domain.YearDomain;

public class BudgetDomainBuilder {
	
	private YearDomain year;
	private PersonDomain person;
	public YearDomain getYear() {
		return year;
	}
	public BudgetDomainBuilder setYear(YearDomain year) {
		this.year = year==null?YearDomainBuilder.get().build():year;
		return this;
	}
	public PersonDomain getPerson() {
		return person;
	}
	public BudgetDomainBuilder setPerson(PersonDomain person) {
		this.person = person== null?PersonDomainBuilder.get().build():person;
		return this;
	}

}
