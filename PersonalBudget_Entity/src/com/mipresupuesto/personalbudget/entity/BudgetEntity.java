package com.mipresupuesto.personalbudget.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.mipresupuesto.personalbudget.crosscuting.utils.UtilObject;
import com.mipresupuesto.personalbudget.crosscuting.utils.UtilUUID;

@Entity
@Table(name="Budget")
public class BudgetEntity {
	@Id
	@Column(name="id")
	private UUID id;
	@ManyToOne
	@JoinColumn(name = "idYear")
	private YearEntity year;
	@ManyToOne
	@JoinColumn(name = "idPerson")
	private PersonEntity person;

	public BudgetEntity() {
		setId(UtilUUID.DEFAULT_UUID);
		setPerson(new PersonEntity());
		setYear(new YearEntity());
	}

	public BudgetEntity(final UUID id,final YearEntity year, final PersonEntity person) {
		setId(id);
		setPerson(person);
		setYear(year);
	}

	public PersonEntity getPerson() {
		if(person == null) {
			setPerson(new PersonEntity());
		}
		return person;
	}

	public void setPerson(final PersonEntity person) {
		this.person = UtilObject.getUtilObject().getDefault(person, new PersonEntity());
	}

	public YearEntity getYear() {
		if(year == null) {
			setYear(new YearEntity());
		}
		return year;
	}

	public void setYear(final YearEntity year) {
		this.year = UtilObject.getUtilObject().getDefault(year, new YearEntity());
	}

	public UUID getId() {
		
		return id;
	}

	public void setId(final UUID id) {
		this.id = UtilUUID.getDefaultUUID(id);
	}

}
