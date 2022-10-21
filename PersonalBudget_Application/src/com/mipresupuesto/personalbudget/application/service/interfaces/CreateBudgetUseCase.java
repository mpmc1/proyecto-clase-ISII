package com.mipresupuesto.personalbudget.application.service.interfaces;

import com.mipresupuesto.personalbudget.domain.BudgetDomain;

public interface CreateBudgetUseCase {
	void execute(BudgetDomain budget);
}
