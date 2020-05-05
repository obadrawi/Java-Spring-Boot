package com.calla.doctor.business.manager;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;

import com.calla.doctor.datamodel.DoctorRepository;
import com.calla.doctor.datamodel.ReservationRepository;
import com.calla.doctor.datamodel.Reservation;
public class ReservationManager {

	private Logger logger = Logger.getLogger(ReservationManager.class);
	@Autowired
	private ReservationRepository reservationRepo;
	
	public List<Reservation> getAllReservations()
	{
		try {
			logger.info("getAllReservations-Start");
			return Lists.newArrayList(reservationRepo.findAll());
			
			}
			finally
			{
				logger.info("getAllReservations-END");
			}
	}
	
	public List<Reservation> getReservationByDay()
	{
		try {
			logger.info("getReservationByDay-Start");
			LocalDate date = LocalDate.now();
			return reservationRepo.findReservationByDay(date.getDayOfMonth(),date.getMonthValue());
			
			}
			finally
			{
				logger.info("getReservationByDay-END");
			}
	}
	
	public String reserveAppointment(Date reservationDate,int clientId,int doctorClinicId)
	{
		try {
			logger.info("getReservationByDay-Start");
			
			Reservation reservation = new Reservation();
			reservation.setDoctorClinicId(doctorClinicId);
			reservation.setPatientId(clientId);
			reservation.setReservationDate(reservationDate);
			reservationRepo.save(reservation);
			return "Success";
			
			}
			finally
			{
				logger.info("getReservationByDay-END");
			}
	}
	
	
	
}
