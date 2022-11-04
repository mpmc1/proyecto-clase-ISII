package com.mipresupuesto.personalbudget.application.specification.implementations;

import java.time.LocalDateTime;
import java.time.Year;
import java.util.Calendar;
import java.util.Date;

import org.springframework.util.NumberUtils;

import com.mipresupuesto.personalbudget.application.specification.AndNotSpecification;
import com.mipresupuesto.personalbudget.application.specification.AndSpecification;
import com.mipresupuesto.personalbudget.application.specification.CompositeSpecification;
import com.mipresupuesto.personalbudget.application.specification.ISpecification;
import com.mipresupuesto.personalbudget.application.specification.NotSpecification;
import com.mipresupuesto.personalbudget.application.specification.OrNotSpecification;
import com.mipresupuesto.personalbudget.application.specification.OrSpecification;
import com.mipresupuesto.personalbudget.crosscuting.utils.UtilNumeric;
import com.mipresupuesto.personalbudget.crosscuting.utils.UtilObject;
import com.mipresupuesto.personalbudget.crosscuting.utils.UtilUUID;
import com.mipresupuesto.personalbudget.domain.YearDomain;

public class YearSpecification extends CompositeSpecification<YearDomain> {
	@Override
	public boolean isSatisfyBy(YearDomain object) {
		return isNotNuLL(object) && isValidId(object) && isValidYear(object);
	}


	private boolean isValidId(YearDomain year) {
		return !UtilObject.getUtilObject().isNull(year.getId())
				&& UtilUUID.getStringFromUuid(year.getId()).length() == 36;
	}

	private boolean isNotNuLL(YearDomain year) {
		return !UtilObject.getUtilObject().isNull(year);
	}

	private boolean isValidYear(YearDomain year) {
		return !UtilObject.getUtilObject().isNull(year)
				&& UtilNumeric.getUtilNumeric().isGreatherThan(year.getYear(), Year.now().getValue());
	}
}
