package com.calla.doctor.business.manager;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.calla.doctor.common.utils.CustomException;
import com.calla.doctor.datamodel.Doctor;
import com.calla.doctor.datamodel.DoctorRepository;
import com.calla.doctor.datamodel.GenericSpecification;
import com.calla.doctor.datamodel.Patient;
import com.calla.doctor.datamodel.PatientRepository;
import com.calla.doctor.datamodel.SearchCriteriaDTO;

public class DoctorManager {
	
	private Logger logger = Logger.getLogger(DoctorManager.class);
	@Autowired
	private DoctorRepository doctorRepo;
	
	public List<Doctor> getAllDoctors()
	{
		try {
		logger.info("getAllDoctors-Start");
		return Lists.newArrayList(doctorRepo.findAll());
		
		}
		finally
		{
			logger.info("getAllDoctors-END");
		}
		
	}
	
	public Doctor getDoctorById(long id)
	{
		try 
		{
			logger.info("getPatientById-Start");
			return doctorRepo.findOne(id);
		}
		finally
		{
			logger.info("getPatientById-END");
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Doctor> getDoctorsByCriteria(List<SearchCriteriaDTO> criterias) throws CustomException
	{
		try 
		{
			logger.info("getPatientsByCriteria-Start");
			
			Specifications<Doctor> doctorpredict = Specifications.
					where(new GenericSpecification<Doctor>(criterias.get(0)));
			for(int i = 1 ; i < criterias.size() ; i++)
			{
				if(criterias.get(i).getConjuction().equals("or"))
				{
					doctorpredict = doctorpredict.or(new GenericSpecification<Doctor>(criterias.get(i)));
				}
				else
				{
					doctorpredict = doctorpredict.and(new GenericSpecification<Doctor>(criterias.get(i)));
				}
				
			}
			
			return doctorRepo.findAll(doctorpredict);
			
		}
		
		catch(NullPointerException | IndexOutOfBoundsException exc)
		{
			throw new CustomException("No Criteria Selected");
		}
		
		finally
		{
			logger.info("getPatientsByCriteria-END");
		}
	}

	
	
	
	

}
