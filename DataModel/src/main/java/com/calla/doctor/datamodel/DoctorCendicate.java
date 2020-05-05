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
@Table(name = "DOCTOR_CENDICATE")
public class DoctorCendicate {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @Column(name = "DOCTOR_ID")
    private long doctorId;
    
    @Column(name = "CENDICATE_ID")
    private long cendicateId;
    
    private BigDecimal discount;
    @ManyToOne
    @JoinColumn(name = "CENDICATE_ID",insertable=false,updatable=false)
    private Cendicate cendicate;
    
    @ManyToOne
    @JoinColumn(name = "DOCTOR_ID",insertable=false,updatable=false)
    private Doctor doctor;
    
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(long doctorId) {
		this.doctorId = doctorId;
	}

	public long getCendicateId() {
		return cendicateId;
	}

	public void setCendicateId(long cendicateId) {
		this.cendicateId = cendicateId;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public Cendicate getCendicate() {
		return cendicate;
	}

	public void setCendicate(Cendicate cendicate) {
		this.cendicate = cendicate;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
}