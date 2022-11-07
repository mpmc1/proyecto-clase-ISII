package com.mipresupuesto.personalbudget.application.specification.implementations;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mipresupuesto.personalbudget.application.specification.CompositeSpecification;
import com.mipresupuesto.personalbudget.crosscuting.exceptions.BudgetException;
import com.mipresupuesto.personalbudget.domain.PersonDomain;
import com.mipresupuesto.personalbudget.entity.PersonEntity;
import com.mipresupuesto.personalbudget.infraestructure.data.interfaces.PersonRepository;

@Service
public class PersonExistSpecification extends CompositeSpecification<PersonDomain>{
	
	@Autowired
	private PersonRepository personRepository;
	
	public boolean isSatisfyBy(PersonDomain object) {
			return personExist(object);
	}
	
	private boolean personExist(PersonDomain person) {
		try {
			Optional<PersonEntity> response = personRepository.findPersonById(person.getId().toString());
			if(response.isEmpty()) {
				throw BudgetException.buildUserException("The given person doesn't exist");
			}
			return true;			
		}catch(Exception exception) {
			throw BudgetException.build("Error trying to get person information", exception.getMessage());
		}
	}
		
}
