package com.calla.doctor.datamodel;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

// CRUD refers Create, Read, Update, Delete

@Repository
public interface PatientRatingRepository extends CrudRepository<PatientRating, Long> {

	 
}