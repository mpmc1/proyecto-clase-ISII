package com.mipresupuesto.personalbudget.application.specification.implementations;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.mipresupuesto.personalbudget.application.specification.CompositeSpecification;
import com.mipresupuesto.personalbudget.crosscuting.exceptions.BudgetException;
import com.mipresupuesto.personalbudget.domain.YearDomain;
import com.mipresupuesto.personalbudget.entity.YearEntity;
import com.mipresupuesto.personalbudget.infraestructure.data.interfaces.YearRepository;


@Service
public class YearExistSpecification extends CompositeSpecification<YearDomain> {
	
	@Autowired
	private YearRepository yearRepository;
	
	public boolean isSatisfyBy(YearDomain object) {
		try {
			return yearExist(object);
		} catch (BudgetException exception) {
			throw exception;
		}
	}
	
	private boolean yearExist(YearDomain year) {
		Optional<YearEntity> response = yearRepository.findById(year.getId());
		if(response.isEmpty()) {
			throw BudgetException.buildUserException("The given year doesn't exist");
		}
		return true;
	}

}
