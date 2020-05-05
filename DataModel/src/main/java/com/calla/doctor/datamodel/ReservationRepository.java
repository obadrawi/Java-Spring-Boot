package com.calla.doctor.datamodel;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

// CRUD refers Create, Read, Update, Delete

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {

	@Query("SELECT r FROM Reservation r WHERE r.reservationDate.date = :date AND r.reservationDate.month = :month")
	public List<Reservation> findReservationByDay(@Param("date") int date,@Param("month") int month);
	@Query("SELECT r FROM Reservation r WHERE r.reservationDate.date = :date AND r.reservationDate.month = :month")
	public List<Reservation> findReservationByPatientId(@Param("date") int date,@Param("month") int month);
}