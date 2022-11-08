package com.mipresupuesto.personalbudget.infraestructure.data.interfaces;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mipresupuesto.personalbudget.entity.PersonEntity;
import com.mipresupuesto.personalbudget.entity.YearEntity;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, UUID> {
	@Query(value="Select * from dbo.Person p where p.id = ?1", nativeQuery=true)
	Optional<PersonEntity> findPersonById(String personId);

}
