package com.mipresupuesto.personalbudget.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.mipresupuesto.personalbudget.crosscuting.utils.UtilNumeric;
import com.mipresupuesto.personalbudget.crosscuting.utils.UtilUUID;

@Entity
@Table(name="Year")
public final class YearEntity {
	@Id
	@Column(name="id")
	private UUID id;
	@Column(name="year")
	private int year;

	public YearEntity() {
		setId(UtilUUID.DEFAULT_UUID);
		setYear(0);
	}

	public YearEntity(UUID id, int year) {
		setId(id);
		setYear(year);
	}

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = UtilUUID.getDefaultUUID(id);
	}

	public int getYear() {
		if (year < 0) {
			setYear(0);
		}
		return year;
	}

	public void setYear(int year) {
		this.year = UtilNumeric.getUtilNumeric().getDefault(year).intValue();
	}

}
