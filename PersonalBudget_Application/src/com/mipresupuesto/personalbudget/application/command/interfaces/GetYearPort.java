package com.mipresupuesto.personalbudget.application.command.interfaces;

import com.mipresupuesto.personalbudget.dto.YearDTO;

public interface GetYearPort {
	YearDTO get(YearDTO year);
}
