package com.mipresupuesto.personalbudget.dto;

import com.mipresupuesto.personalbudget.crosscuting.utils.UtilText;

public final class PersonDTO {
	private String id;
	private String idCard;
	private String firstName;
	private String middleName;
	private String lastName;
	private String name;
	private String completeName;

	public PersonDTO() {
		setId("");
		setIdCard("");
		setFirstName("");
		setMiddleName("");
		setLastName("");
		setName("");
		setCompleteName("");
	}

	public PersonDTO(final String id, final String idCard, final String firstName, final String middleName,
			final String lastName, final String name, final String completeName) {
		setId(id);
		setIdCard(idCard);
		setFirstName(firstName);
		setMiddleName(middleName);
		setLastName(lastName);
		setName(name);
		setCompleteName(completeName);
	}

	public static final PersonDTO create() {
		return new PersonDTO();
	}

	public final String getId() {
		return id;
	}

	public final void setId(final String id) {
		this.id = UtilText.trim(id);
	}

	public final String getIdCard() {
		if (idCard == null) {
			setIdCard("");
		}
		return idCard.trim();
	}

	public final void setIdCard(final String idCard) {
		this.idCard = UtilText.trim(idCard);
	}

	public final String getFirstName() {
		if (firstName == null) {
			setFirstName("");
		}
		return firstName.trim();
	}

	public final void setFirstName(final String firstName) {
		this.firstName = UtilText.trim(firstName);
	}

	public final String getMiddleName() {
		if (middleName == null) {
			setMiddleName("");
		}
		return middleName.trim();
	}

	public final void setMiddleName(final String middleName) {
		this.middleName = UtilText.trim(middleName);
	}

	public final String getLastName() {
		if (lastName == null) {
			setLastName("");
		}
		return lastName.trim();
	}

	public final void setLastName(final String lastName) {
		this.lastName = UtilText.trim(lastName);
	}

	public String getName() {
		if (name == null) {
			setName("");
		}
		return name.trim();
	}

	public void setName(String name) {
		this.name = UtilText.trim(name);
	}

	public String getCompleteName() {
		if (completeName == null) {
			setCompleteName("");
		}
		return completeName.trim();
	}

	public void setCompleteName(String completeName) {
		this.completeName = UtilText.trim(completeName);
	}

}
