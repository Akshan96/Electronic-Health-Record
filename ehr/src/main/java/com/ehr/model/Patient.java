package com.ehr.model;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "patient_id")
    private int id;
    
    public boolean isVerified() {
		return isVerified();
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}
    
    @Column(name = "userId")
    private int userId;
    
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "DOB")
	private Date dob;
	
	@Column(name = "permnant_add")
	private String permnantAddress;
	
	@Column(name = "residential_add")
	private String residentialAddress;
	
	@Column(name = "mobile_number")
	private String mobileNumber;
	
	@Column(name = "alternate_number")
	private String alternateNumber;

	private Object verified;

	/*public Patient() 
	{
	}*/
	
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Patient(int id, int userId, String firstName, String lastName, Date dob, String permnantAddress,
			String residentialAddress, String mobileNumber, String alternateNumber, Object verified) 
	{
		super();
		this.id = id;
		this.userId = userId;
		this.firstName = firstName;
		this.verified = verified;
		this.lastName = lastName;
		this.dob = dob;
		this.permnantAddress = permnantAddress;
		this.residentialAddress = residentialAddress;
		this.mobileNumber = mobileNumber;
		this.alternateNumber = alternateNumber;
	}
	

	public int getPatientId() {
		return id;
	}

	public void setPatientId(int id) {
		this.id = id;
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

	/*public void setVerified(boolean b) {
		// TODO Auto-generated method stub
		
	}

	/*public int getId() {
		// TODO Auto-generated method stub
		return patientId;
	}*/

	public void setId(String id) {
		// TODO Auto-generated method stub
		
	}

	public Object getAddress() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setAddress(Object address) {
		// TODO Auto-generated method stub
		
	}

	public Object getExperience() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setExperience(Object experience) {
		// TODO Auto-generated method stub
		
	}

	public Object getPhoneNumber() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setPhoneNumber(Object phoneNumber) {
		// TODO Auto-generated method stub
		
	}

	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	

}
