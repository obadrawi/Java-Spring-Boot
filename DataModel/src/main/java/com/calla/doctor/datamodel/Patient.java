package com.calla.doctor.datamodel;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "PATIENTS")
public class Patient {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    private String firstName;

    private String lastName;
    
    @Column(name = "CENDICATE_ID")
    private Long cendicateId;
    
    private String address;
    
    private String telephoneNumber;
    
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    
    @Column(name = "CITY_ID")
    private long cityId;
    
    private String patientKey;
    
    @ManyToOne
    @JoinColumn(name = "CITY_ID",insertable=false,updatable=false)
    private City city;
    
    @ManyToOne
    @JoinColumn(name = "CENDICATE_ID",insertable=false,updatable=false)
    private Cendicate cendicate;
    
    @OneToMany(mappedBy = "patient")
    private List<PatientHistory> patientHistory;
    
    @OneToMany(mappedBy = "patient")
    private List<Comment> comments;
    
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getCendicateId() {
		return cendicateId;
	}

	public void setCendicateId(Long cendicateId) {
		this.cendicateId = cendicateId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public long getCityId() {
		return cityId;
	}

	public void setCityId(long cityId) {
		this.cityId = cityId;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Cendicate getCendicate() {
		return cendicate;
	}

	public void setCendicate(Cendicate cendicate) {
		this.cendicate = cendicate;
	}

	@JsonIgnore
	public List<PatientHistory> getPatientHistory() {
		return patientHistory;
	}

	public void setPatientHistory(List<PatientHistory> patientHistory) {
		this.patientHistory = patientHistory;
	}

	@JsonIgnore
	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public String getPatientKey() {
		return patientKey;
	}

	public void setPatientKey(String patientKey) {
		this.patientKey = patientKey;
	}



}