package com.mipresupuesto.personalbudget.entity;

import java.util.UUID;

public final class YearEntity {
	private UUID id;
	private int year;

	public YearEntity() {
		setYear(0);
	}

	public YearEntity(String id, int year) {
		setYear(year);
	}

	public final UUID getId() {
		return id;
	}

	public final void setId(final UUID id) {
		this.id = id;
	}

	public final int getYear() {
		if (year < 0) {
			setYear(0);
		}
		return year;
	}

	public final void setYear(final int year) {
		this.year = year;
	}

}
