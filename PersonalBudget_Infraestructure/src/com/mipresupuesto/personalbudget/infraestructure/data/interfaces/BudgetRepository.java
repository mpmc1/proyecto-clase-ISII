package com.mipresupuesto.personalbudget.infraestructure.data.interfaces;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mipresupuesto.personalbudget.entity.BudgetEntity;

@Repository
public interface BudgetRepository extends JpaRepository<BudgetEntity, UUID>{
	
	@Query(value="SELECT * FROM dbo.Budget b WHERE b.idPerson = ?1 AND b.idYear = ?2", nativeQuery = true)
	Optional<BudgetEntity> findBudgetByPersonAndYear(String personId, String yearId);
	
	@Modifying
	@Query(value="INSERT INTO dbo.Budget(id, idYear, idPerson) VALUES(?1,?2,?3)", nativeQuery = true)
	void createBudgetByPersonAndYear(String budgetId, String yearId, String personId);

}