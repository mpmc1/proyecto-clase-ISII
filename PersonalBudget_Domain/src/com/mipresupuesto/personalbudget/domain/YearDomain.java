package com.mipresupuesto.personalbudget.domain;

public final class YearDomain {
	
	private final  String id;
	private final int year;

	private YearDomain(String id, int year) {
		this.id = id;
		this.year = year;
		
	}
	
	public static YearDomain build(String id, int year) {
		return new YearDomain(id, year);
	}

	public final String getId() {
		return id;
	}

	public final int getYear() {
		return year;
	}
	
	
}
