package com.calla.doctor.business.manager;

import java.util.List;

import org.apache.log4j.Logger;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;

import com.calla.doctor.datamodel.Doctor;
import com.calla.doctor.datamodel.DoctorClinic;
import com.calla.doctor.datamodel.DoctorClinicRepository;
import com.calla.doctor.datamodel.DoctorRepository;

public class DoctorClinicManager {
	
	private Logger logger = Logger.getLogger(DoctorClinicManager.class);
	@Autowired
	private DoctorClinicRepository doctorClinicRepo;
	
	public List<DoctorClinic> getAllDoctorsandClinics()
	{
		try {
		logger.info("getAllDoctors-Start");
		return Lists.newArrayList(doctorClinicRepo.findAll());
		
		}
		finally
		{
			logger.info("getAllDoctors-END");
		}
		
	}

}
