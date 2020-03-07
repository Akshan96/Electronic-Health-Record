package com.ehr.model;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "patient_id")
    private int patientId;
    
    @Column(name = "userId")
    private int userId;
    
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "dob")
	private Date dob;
	
	@Column(name = "permnant_add")
	private String permnantAddress;
	
	@Column(name = "residential_add")
	private String residentialAddress;
	
	@Column(name = "mobile_number")
	private String mobileNumber;
	
	@Column(name = "alternate_number")
	private String alternateNumber;

	public Patient() {
	}
	
	public Patient(int patientId, int userId, String firstName, String lastName, Date dob, String permnantAddress,
			String residentialAddress, String mobileNumber, String alternateNumber) {
		super();
		this.patientId = patientId;
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.permnantAddress = permnantAddress;
		this.residentialAddress = residentialAddress;
		this.mobileNumber = mobileNumber;
		this.alternateNumber = alternateNumber;
	}
	

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getPermnantAddress() {
		return permnantAddress;
	}

	public void setPermnantAddress(String permnantAddress) {
		this.permnantAddress = permnantAddress;
	}

	public String getResidentialAddress() {
		return residentialAddress;
	}

	public void setResidentialAddress(String residentialAddress) {
		this.residentialAddress = residentialAddress;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAlternateNumber() {
		return alternateNumber;
	}

	public void setAlternateNumber(String alternateNumber) {
		this.alternateNumber = alternateNumber;
	}
	

}
