package com.mipresupuesto.personalbudget.application.command.interfaces;

import com.mipresupuesto.personalbudget.dto.PersonDTO;

public interface GetPersonPort {
	PersonDTO get(PersonDTO person);
}
