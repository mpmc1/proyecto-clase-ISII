package com.mipresupuesto.personalbudget.dto;

import java.util.UUID;

import com.mipresupuesto.personalbudget.crosscuting.utils.UtilObject;
import com.mipresupuesto.personalbudget.crosscuting.utils.UtilUUID;

public final class BudgetDTO {
	private String id;
	private YearDTO year;
	private PersonDTO person;

	public BudgetDTO() {
		setId(UtilUUID.DEFAULT_UUID_STRING);
		setPerson(PersonDTO.create());
		setYear(YearDTO.create());
	}

	public BudgetDTO(final String id,final YearDTO year, final PersonDTO person) {
		setPerson(person);
		setYear(year);
		setId(id);
	}

	public static final BudgetDTO create() {
		return new BudgetDTO();
	}

	public PersonDTO getPerson() {
		if(UtilObject.getUtilObject().isNull(person)) {
			setPerson(PersonDTO.create());
		}
		return person;
	}

	public final void setPerson(final PersonDTO person) {
		this.person = UtilObject.getUtilObject().getDefault(person, new PersonDTO());
	}

	public final YearDTO getYear() {
		if(UtilObject.getUtilObject().isNull(year)) {
			setYear(YearDTO.create());
		}
		return year;
	}

	public final void setYear(final YearDTO year) {
		this.year = UtilObject.getUtilObject().getDefault(year, new YearDTO());
	}
	public final String getId() {
		return id;
	}
	
	public final void setId(final String id) {
		this.id = UtilUUID.getDefaultUUID(UtilUUID.getUuidFromString(id)).toString();
	}

}
