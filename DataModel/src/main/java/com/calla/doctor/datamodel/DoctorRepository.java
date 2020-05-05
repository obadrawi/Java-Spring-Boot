package com.calla.doctor.datamodel;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;



@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long>, JpaSpecificationExecutor<Doctor> {
	
	@Query("SELECT d FROM Doctor d WHERE d.specialtyId = :specialityId")
	public List<Doctor> findDoctorBySpeciality(@Param("specialityId") long specialityId);
	
	@Query("SELECT d FROM Doctor d WHERE d.name like %:name%")
	public List<Doctor> findDoctorByName(@Param("name") String name);

}