package com.mipresupuesto.personalbudget.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.mipresupuesto.personalbudget.crosscuting.utils.UtilUUID;


@Entity
@Table(name ="Person")
public class PersonEntity {
	@Id
	@Column(name="id")
	private UUID id;
	@Column(name="idCard")
	private String idCard;
	@Column(name="firstName")
	private String firstName;
	@Column(name="middleName")
	private String middleName;
	@Column(name="lastName")
	private String lastName;
	private String name;
	private String completeName;

	public PersonEntity() {
		setId(UtilUUID.DEFAULT_UUID);
		setIdCard("");
		setFirstName("");
		setMiddleName("");
		setLastName("");
		setName("");
		setCompleteName("");
	}

	public PersonEntity(final String idCard, final String firstName, final String middleName, final String lastName,
			final String name, final String completeName) {
		setIdCard(idCard);
		setFirstName(firstName);
		setMiddleName(middleName);
		setLastName(lastName);
		setName(name);
		setCompleteName(completeName);
	}

	public final UUID getId() {
		return id;
	}

	public final void setId(final UUID id) {
		this.id = UtilUUID.getDefaultUUID(id);
	}

	public final String getIdCard() {
		if (idCard == null) {
			setIdCard("");
		}
		return idCard.trim();
	}

	public final void setIdCard(final String idCard) {
		this.idCard = idCard;
	}

	public final String getFirstName() {
		if (firstName == null) {
			setFirstName("");
		}
		return firstName.trim();
	}

	public final void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	public final String getMiddleName() {
		if (middleName == null) {
			setMiddleName("");
		}
		return middleName.trim();
	}

	public final void setMiddleName(final String middleName) {
		this.middleName = middleName;
	}

	public final String getLastName() {
		if (lastName == null) {
			setLastName("");
		}
		return lastName.trim();
	}

	public final void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	public String getName() {
		if (name == null) {
			setName("");
		}
		return name.trim();
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompleteName() {
		if (completeName == null) {
			setCompleteName("");
		}
		return completeName.trim();
	}

	public void setCompleteName(String completeName) {
		this.completeName = completeName;
	}

}
