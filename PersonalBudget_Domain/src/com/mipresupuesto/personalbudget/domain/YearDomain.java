package com.mipresupuesto.personalbudget.domain;

import java.util.UUID;

import com.mipresupuesto.personalbudget.crosscuting.utils.UtilNumeric;
import com.mipresupuesto.personalbudget.crosscuting.utils.UtilObject;
import com.mipresupuesto.personalbudget.crosscuting.utils.UtilUUID;
import com.mipresupuesto.personalbudget.domain.build.YearDomainBuilder;

public final class YearDomain {

	private UUID id;
	private int year;

	private YearDomain(UUID id, int year) {
		setId(id);
		setYear(year);

	}

	public static YearDomain build(UUID id, int year) {
		return new YearDomain(id, year);
	}

	public final UUID getId() {
		return id;
	}

	public final int getYear() {
		return year;
	}

	public final void setId(UUID id) {
		this.id = UtilUUID.getDefaultUUID(id);
	}

	public final void setYear(int year) {
		this.year = UtilNumeric.getUtilNumeric().getDefault(year).intValue();
	}

}
