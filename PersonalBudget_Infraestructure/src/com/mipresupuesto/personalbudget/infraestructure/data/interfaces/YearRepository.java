package com.mipresupuesto.personalbudget.infraestructure.data.interfaces;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mipresupuesto.personalbudget.entity.YearEntity;

@Repository
public interface YearRepository extends JpaRepository<YearEntity, UUID                                                                                                                                                               >  {
	
}
