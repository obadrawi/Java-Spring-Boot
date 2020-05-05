package com.calla.doctor.datamodel;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "PATIENT_HISTORY")
public class PatientHistory {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @Column(name = "PATIENT_ID")
    private long patientId;
    
    @Column(name = "DOCTOR_CLINIC_ID")
    private long doctorClinicId;
    
    private String history;
    
    @ManyToOne
    @JoinColumn(name = "PATIENT_ID",insertable=false,updatable=false)
    private Patient patient;
     
    @ManyToOne
    @JoinColumn(name = "DOCTOR_CLINIC_ID",insertable=false,updatable=false)
   private DoctorClinic doctorClinic;
    
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getPatientId() {
		return patientId;
	}

	public void setPatientId(long patientId) {
		this.patientId = patientId;
	}

	public long getDoctorClinicId() {
		return doctorClinicId;
	}

	public void setDoctorClinicId(long doctorClinicId) {
		this.doctorClinicId = doctorClinicId;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public DoctorClinic getDoctorClinic() {
		return doctorClinic;
	}

	public void setDoctorClinic(DoctorClinic doctorClinic) {
		this.doctorClinic = doctorClinic;
	}

}