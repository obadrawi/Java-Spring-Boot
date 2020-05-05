package com.calla.doctor.business.model;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.calla.doctor.business.manager.PatientManager;
import com.calla.doctor.common.utils.CustomException;
import com.calla.doctor.datamodel.Doctor;
import com.calla.doctor.datamodel.Patient;
import com.calla.doctor.datamodel.PatientHistory;
import com.calla.doctor.datamodel.PatientRepository;
import com.calla.doctor.datamodel.SearchCriteriaDTO;


@Configuration
@ComponentScan("com.calla.doctor")

@Controller    // This means that this class is a Controller
@RequestMapping(path="/patients") // This means URL's start with /demo (after Application path)
public class PatientController {
	@Autowired
	PatientManager patientManager;

	@GetMapping(path="/getPatientByFullName")
	public @ResponseBody List<Patient> getPatientbyFullName(@RequestParam String firstName, @RequestParam String lastName)
	{
		return patientManager.getPatientByFullName(firstName, lastName);
	}
	
	@GetMapping(path="/")
	public @ResponseBody List<Patient> getAllPatients()
	{
		return patientManager.getAllPatient();
	}
	
	@PostMapping(path="/patient")
	public @ResponseBody List<Patient> getPatientbyCriterias(@RequestBody List<SearchCriteriaDTO> searchCriterias) throws CustomException {
		// This returns a JSON or XML with the users
		
		return patientManager.getPatientsByCriteria(searchCriterias);
	}
	
	@GetMapping(path="/getPatientHistory/patientId/{patientId}/patientKey")
	public @ResponseBody List<PatientHistory> getPatientbyFullName(@PathParam("patientId") long patientId, @PathParam("patientKey") String patientKey) throws CustomException
	{
		return patientManager.getPatientHistory(patientId, patientKey);
	}
	
	@GetMapping(path="/getPatientById")
	public @ResponseBody Patient getPatientbyId(@RequestParam long id)
	{
		return patientManager.getPatientById(id);
	}
	
	@PostMapping(path="/patient/insert")
	public @ResponseBody String InsertPatient(@RequestBody Patient patient) throws CustomException {
		// This returns a JSON or XML with the users
		
		 patientManager.insertPaient(patient);
		 
		 return "Success";
	}
}