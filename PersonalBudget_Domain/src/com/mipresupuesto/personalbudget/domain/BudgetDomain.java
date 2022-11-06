
package com.mipresupuesto.personalbudget.domain;

import java.util.UUID;

import com.mipresupuesto.personalbudget.crosscuting.utils.UtilObject;
import com.mipresupuesto.personalbudget.crosscuting.utils.UtilUUID;
import com.mipresupuesto.personalbudget.domain.build.PersonDomainBuilder;
import com.mipresupuesto.personalbudget.domain.build.YearDomainBuilder;

public class BudgetDomain {

	private UUID id;
	private YearDomain year;
	private PersonDomain person;

	private BudgetDomain(final UUID id, final YearDomain year, final PersonDomain person) {
		setId(id);
		setYear(year);
		setPerson(person);
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

	public final UUID getId() {
		return id;
	}

	public final void setId(final UUID id) {
		this.id = UtilUUID.getDefaultUUID(id);
	}

	public final void setYear(final YearDomain year) {
		this.year = UtilObject.getUtilObject().getDefault(year, YearDomainBuilder.get().build());
	}

	public final void setPerson(PersonDomain person) {
		this.person = UtilObject.getUtilObject().getDefault(person, PersonDomainBuilder.get().build());
	}

}
