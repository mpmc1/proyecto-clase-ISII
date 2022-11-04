package com.mipresupuesto.personalbudget.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.mipresupuesto.personalbudget.crosscuting.utils.UtilText;
import com.mipresupuesto.personalbudget.crosscuting.utils.UtilUUID;

@Entity
@Table(name = "Person")
public class PersonEntity {
	@Id
	@Column(name = "id")
	private UUID id;
	@Column(name = "idCard")
	private String idCard;
	@Column(name = "firstName")
	private String firstName;
	@Column(name = "middleName")
	private String middleName;
	@Column(name = "lastName")
	private String lastName;

	public PersonEntity() {
		setId(UtilUUID.DEFAULT_UUID);
		setIdCard(UtilText.EMPTY);
		setFirstName(UtilText.EMPTY);
		setMiddleName(UtilText.EMPTY);
		setLastName(UtilText.EMPTY);
	}

	public PersonEntity(final UUID id, final String idCard, final String firstName, final String middleName,
			final String lastName) {
		setId(id);
		setIdCard(idCard);
		setFirstName(firstName);
		setMiddleName(middleName);
		setLastName(lastName);
	}

	public UUID getId() {
		if (UtilUUID.isNull(id)) {
			setId(UtilUUID.DEFAULT_UUID);
		}

		return id;
	}

	public void setId(final UUID id) {
		this.id = UtilUUID.getDefaultUUID(id);
	}

	public String getIdCard() {
		if (UtilText.isNull(idCard)) {
			setIdCard(UtilText.EMPTY);
		}
		return idCard.trim();
	}

	public void setIdCard(final String idCard) {
		this.idCard = UtilText.trim(idCard);
	}

	public String getFirstName() {
		if (UtilText.isNull(firstName)) {
			setFirstName(UtilText.EMPTY);
		}
		return firstName.trim();
	}

	public void setFirstName(final String firstName) {
		this.firstName = UtilText.trim(firstName);
	}

	public String getMiddleName() {
		if (UtilText.isNull(middleName)) {
			setMiddleName(UtilText.EMPTY);
		}
		return middleName.trim();
	}

	public void setMiddleName(final String middleName) {
		this.middleName = UtilText.trim(middleName);
	}

	public String getLastName() {
		if (UtilText.isNull(lastName)) {
			setLastName(UtilText.EMPTY);
		}
		
		return lastName.trim();
	}

	public void setLastName(final String lastName) {
		this.lastName = UtilText.trim(lastName);
	}

}
