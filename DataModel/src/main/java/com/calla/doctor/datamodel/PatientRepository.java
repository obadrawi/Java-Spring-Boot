package com.calla.doctor.datamodel;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

// CRUD refers Create, Read, Update, Delete

@Repository
public interface PatientRepository extends CrudRepository<Patient, Long>, JpaSpecificationExecutor<Patient> {

	 @Query("SELECT p FROM Patient p WHERE LOWER(p.lastName) = LOWER(:lastName) AND LOWER(p.firstName) = LOWER(:firstName)")
	public List<Patient> findByFullName(@Param("firstName") String firstName, @Param("lastName") String lastName);
	 
}