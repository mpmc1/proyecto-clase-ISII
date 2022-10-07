package com.mipresupuesto.personalbudget.domain.build;

import com.mipresupuesto.personalbudget.domain.PersonDomain;
import com.mipresupuesto.personalbudget.domain.YearDomain;

public class PersonDomainBuilder {

	private String id;
	private String idCard;
	private String firstName;
	private String middleName;
	private String lastName;
	
	
	private PersonDomainBuilder() {
		setId("");
		setIdCard("");
		setFirstName("");
		setMiddleName("");
		setLastName("");
	}
	
	public static final PersonDomainBuilder get() {
		return new PersonDomainBuilder();
	}

	

	private final String getId() {
		return id;
	}
	public final PersonDomainBuilder setId(String id) {
		this.id = id == null?"":id.trim();
		return this;

	}
	private final String getIdCard() {
		return idCard;
	}
	

	public final PersonDomainBuilder setIdCard(String idCard) {
		this.idCard = idCard == null?"":idCard.trim();
		return this;

	}

	private final String getFirstName() {
		return firstName;
	}

	public final PersonDomainBuilder setFirstName(String firstName) {
		this.firstName = firstName == null?"":firstName.trim();
		return this;

	}

	private final String getMiddleName() {
		return middleName;
	}

	public final PersonDomainBuilder setMiddleName(String middleName) {
		this.middleName = middleName == null?"":middleName.trim();
		return this;

	}

	private final String getLastName() {
		return lastName;
	}

	public final PersonDomainBuilder setLastName(String lastName) {
		this.lastName = lastName == null?"":lastName.trim();
		return this;
	}
	public PersonDomain build() {
		return PersonDomain.build(getId(),getIdCard(), getFirstName(), getMiddleName(), getLastName());
	}
	
}
