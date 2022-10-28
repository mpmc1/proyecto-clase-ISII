package com.mipresupuesto.personalbudget.domain;

import java.util.UUID;

import com.mipresupuesto.personalbudget.crosscuting.utils.UtilText;
import com.mipresupuesto.personalbudget.crosscuting.utils.UtilUUID;

public class PersonDomain {
	private UUID id;
	private String idCard;
	private String firstName;
	private String middleName;
	private String lastName;

	private PersonDomain(UUID id, String idCard, String firstName, String middleName, String lastName) {
		setId(id);
		setIdCard(idCard);
		setFirstName(firstName);
		setMiddleName(middleName);
		setLastName(lastName);

	}

	public static PersonDomain build(UUID id, String idCard, String firstName, String middleName, String lastName) {
		return new PersonDomain(id, idCard, firstName, middleName, lastName);
	}

	public final UUID getId() {
		return id;
	}

	public final String getIdCard() {
		return idCard;
	}

	public final String getFirstName() {
		return firstName;
	}

	public final String getMiddleName() {
		return middleName;
	}

	public final String getLastName() {
		return lastName;
	}

	public final String getName() {
		return (getFirstName() + " " + getMiddleName()).trim();
	}

	public final String getCompleteName() {
		return (getName() + " " + getLastName()).trim();
	}

	public final void setId(UUID id) {
		this.id = UtilUUID.getDefaultUUID(id);
	}

	public final void setIdCard(String idCard) {
		this.idCard = UtilText.trim(idCard);
	}

	public final void setFirstName(String firstName) {
		this.firstName = UtilText.trim(firstName);
	}

	public final void setMiddleName(String middleName) {
		this.middleName = UtilText.trim(middleName);
	}

	public final void setLastName(String lastName) {
		this.lastName = UtilText.trim(lastName);
	}

}
