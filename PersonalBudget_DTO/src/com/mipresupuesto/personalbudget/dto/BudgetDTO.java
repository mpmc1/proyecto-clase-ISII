package com.mipresupuesto.personalbudget.dto;

import com.mipresupuesto.personalbudget.crosscuting.utils.UtilObject;

public final class BudgetDTO {
	private YearDTO year;
	private PersonDTO person;

	public BudgetDTO() {
		setPerson(PersonDTO.create());
		setYear(YearDTO.create());
	}

	public BudgetDTO(final YearDTO year, final PersonDTO person) {
		setPerson(person);
		setYear(year);
	}

	public static final BudgetDTO create() {
		return new BudgetDTO();
	}

	public PersonDTO getPerson() {
		if(person == null) {
			setPerson(PersonDTO.create());
		}
		return person;
	}

	public final void setPerson(final PersonDTO person) {
		this.person = UtilObject.getUtilObject().getDefault(person, new PersonDTO());
	}

	public final YearDTO getYear() {
		if(year == null) {
			setYear(YearDTO.create());
		}
		return year;
	}

	public final void setYear(final YearDTO year) {
		this.year = UtilObject.getUtilObject().getDefault(year, new YearDTO());
	}

}
