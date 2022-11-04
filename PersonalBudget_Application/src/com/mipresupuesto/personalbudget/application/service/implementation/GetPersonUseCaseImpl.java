package com.mipresupuesto.personalbudget.application.service.implementation;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mipresupuesto.personalbudget.application.service.entityassembler.EntityAssembler;
import com.mipresupuesto.personalbudget.application.service.interfaces.GetPersonUseCase;
import com.mipresupuesto.personalbudget.domain.PersonDomain;
import com.mipresupuesto.personalbudget.entity.PersonEntity;
import com.mipresupuesto.personalbudget.infraestructure.data.interfaces.PersonRepository;

@Service
@Transactional
public class GetPersonUseCaseImpl implements GetPersonUseCase {
	
	@Autowired
	EntityAssembler<PersonEntity, PersonDomain> entityAssembler;
	@Autowired
	PersonRepository personRepository;

	@Override
	public PersonDomain get(PersonDomain person) {
		PersonEntity personEntity = entityAssembler.assembleEntity(person);
		Optional<PersonEntity> response = personRepository.findById(personEntity.getId());
		if(response.isPresent()) {
			return entityAssembler.assembleDomain(response.get());
		}else {
			return null;
		}
		
	}

}
