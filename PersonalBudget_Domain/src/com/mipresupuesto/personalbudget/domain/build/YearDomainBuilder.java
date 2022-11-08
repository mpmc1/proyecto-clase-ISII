package com.mipresupuesto.personalbudget.domain.build;

import java.util.UUID;

import com.mipresupuesto.personalbudget.crosscuting.utils.UtilUUID;
import com.mipresupuesto.personalbudget.domain.YearDomain;

public class YearDomainBuilder {
	
	private UUID id;
	private int year;
	
	private YearDomainBuilder() {
		setId(UtilUUID.DEFAULT_UUID);
		setYear(0);
	}
	
	public static final YearDomainBuilder get() {
		return new YearDomainBuilder();
	}

	private final UUID getId() {
		return id;
	}

	private final int getYear() {
		return year;
	}

	public final YearDomainBuilder setId(UUID id) {
		this.id =UtilUUID.getDefaultUUID(id);
		return this;
	}
	
	public YearDomain build() {
		return YearDomain.build(getId(),getYear());
	}

	public final YearDomainBuilder setYear(int year) {
		this.year = year;
		return this;
	}
	

}
