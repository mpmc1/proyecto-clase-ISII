package com.mipresupuesto.personalbudget.domain.build;

import com.mipresupuesto.personalbudget.domain.YearDomain;

public class YearDomainBuilder {
	
	private String id;
	private int year;
	
	private YearDomainBuilder() {
		setId("");
		setYear(0);
	}
	
	public static final YearDomainBuilder get() {
		return new YearDomainBuilder();
	}

	private final String getId() {
		return id;
	}

	private final int getYear() {
		return year;
	}

	public final YearDomainBuilder setId(String id) {
		this.id = id ==null?"":id.trim();
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
