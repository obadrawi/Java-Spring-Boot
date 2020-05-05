package com.calla.doctor.datamodel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// This will be AUTO IMPLEMENTED by Spring longo a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

@Repository
public interface CendicateRepository extends CrudRepository<Cendicate, Long> {

}