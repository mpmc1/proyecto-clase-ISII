package com.mipresupuesto.personalbudget.domain;

public class PersonDomain {
	private final String id;
	private final String idCard;
	private final String firstName;
	private final String middleName;
	private final String lastName;
	
	private PersonDomain(String id, String idCard, String firstName, String middleName, String lastName) {
		this.id = id;
		this.idCard = idCard;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		
	}
	
	public static PersonDomain build(String id, String idCard, String firstName, String middleName, String lastName) {
		return new PersonDomain(id, idCard, firstName, middleName, lastName );
	}

	public final String getId() {
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


	
}
