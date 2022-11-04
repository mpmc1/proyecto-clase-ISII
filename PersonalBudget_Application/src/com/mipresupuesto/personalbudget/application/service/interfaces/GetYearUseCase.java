package com.mipresupuesto.personalbudget.application.service.interfaces;

import com.mipresupuesto.personalbudget.domain.YearDomain;

public interface GetYearUseCase {
	YearDomain get(YearDomain year);
}
