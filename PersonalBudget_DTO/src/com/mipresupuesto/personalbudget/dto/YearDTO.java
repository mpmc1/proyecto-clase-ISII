package com.mipresupuesto.personalbudget.dto;

import com.mipresupuesto.personalbudget.crosscuting.utils.UtilNumeric;
import com.mipresupuesto.personalbudget.crosscuting.utils.UtilText;

public final class YearDTO {
	private String id;
	private int year;

	public YearDTO() {
		setId(UtilText.EMPTY);
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
		if (UtilText.isNull(id)) {
			setId(UtilText.EMPTY);
		}
		return id.trim();
	}
	

	public final void setId(final String id) {
		this.id = UtilText.trim(id);
	}

	public final int getYear() {
		if (year < 0) {
			setYear(0);
		}
		return year;
	}

	public final void setYear(final int year) {
		this.year = UtilNumeric.getUtilNumeric().getDefault(year).intValue();
	}

}
