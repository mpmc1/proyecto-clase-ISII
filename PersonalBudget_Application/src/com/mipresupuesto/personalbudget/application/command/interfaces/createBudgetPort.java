package com.mipresupuesto.personalbudget.application.command.interfaces;

import com.mipresupuesto.personalbudget.dto.BudgetDTO;

public interface createBudgetPort {
	void execute(BudgetDTO budget);
}
