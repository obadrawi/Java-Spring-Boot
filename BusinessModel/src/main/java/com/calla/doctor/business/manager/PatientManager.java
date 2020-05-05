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
import com.calla.doctor.datamodel.PatientHistory;
import com.calla.doctor.datamodel.PatientHistoryRepository;
import com.calla.doctor.datamodel.PatientRepository;
import com.calla.doctor.datamodel.SearchCriteriaDTO;

public class PatientManager {
	
	private Logger logger = Logger.getLogger(PatientManager.class);
	@Autowired
	private PatientRepository patientRepo;
	
	@Autowired
	private PatientHistoryRepository patientHistoryRepo;
	
	public List<Patient> getAllPatient()
	{
		try {
		logger.info("getAllPatient-Start");
		return Lists.newArrayList(patientRepo.findAll());
		
		}
		finally
		{
			logger.info("getAllPatient-END");
		}
		
	}
	
	public Patient getPatientById(long id)
	{
		try 
		{
			logger.info("getPatientById-Start "+id );
			return patientRepo.findOne(id);
		}
		finally
		{
			logger.info("getPatientById-END");
		}
	}
	
	public List<Patient> getPatientByFullName(String firstName,String lastName)
	{
		return patientRepo.findByFullName(firstName,lastName);
	}
	public void insertPaient(Patient patient)
	{
		try 
		{
			logger.info("insertPaient-Start");
			
			patientRepo.save(patient);
		}
		
		finally
		{
			logger.info("insertPaient-END");
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Patient> getPatientsByCriteria(List<SearchCriteriaDTO> criterias) throws CustomException
	{
		try 
		{
			logger.info("getPatientsByCriteria-Start");
			
			Specifications<Patient> patientpredict = Specifications.
					where(new GenericSpecification<Patient>(criterias.get(0)));
			for(int i = 1 ; i < criterias.size() ; i++)
			{
				if(criterias.get(i).getConjuction().equals("or"))
				{
					patientpredict.or(new GenericSpecification<Patient>(criterias.get(i)));
				}
				else
				{
					patientpredict.and(new GenericSpecification<Patient>(criterias.get(i)));
				}
				
			}
			return patientRepo.findAll(patientpredict);
			
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
	
	public List<PatientHistory> getPatientHistory(long patientId,String patientKey) throws CustomException
	{
		try 
		{
			logger.info("getPatientHistory-Start");
			Patient patient = getPatientById(patientId);
			
			if(patientKey.equals(patient.getPatientKey()))
			{
				return patient.getPatientHistory();
			}
			else
			{
				throw new CustomException("patient Key is not right");
			}
			
		}
		
		finally
		{
			logger.info("getPatientHistory-END");
		}
	}

	
	
	
	

}
