package com.mipresupuesto.personalbudget.dto;

public final class YearDTO {
	private String id;
	private int year;

	public YearDTO() {
		setId("");
		setYear(0);
	}

	public YearDTO(String id, int year) {
		setId(id);
		setYear(year);
	}

	public static final YearDTO create() {
		return new YearDTO();
	}

	public final String getId() {
		if (id == null) {
			setId("");
		}
		return id.trim();
	}

	public final void setId(final String id) {
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
