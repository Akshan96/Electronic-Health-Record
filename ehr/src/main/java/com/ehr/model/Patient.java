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
    
    public boolean isVerified() {
		return isVerified();
	}

	public void setVerified(boolean verified) {
	}
    
    @Column(name = "userId")
    private int userId;
    
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "spouse name")
	private String spouseName;
	
	@Column(name = "DOB")
	private Date dob;
	
	@Column(name = "registration date")
	private Date registrationDate;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "height")
    private int height;
	
	@Column(name = "weight")
    private int weight;
	
	@Column(name = "permnant_add")
	private String permnantAddress;
	
	@Column(name = "residential_add")
	private String residentialAddress;
	
	@Column(name = "mobile_number")
	private String mobileNumber;
	
	@Column(name = "alternate_number")
	private String alternateNumber;
	
	@Column(name = "patient_emailID")
	private String patientEmailId;
	
	@Column(name = "insurance Id")
	private String insuranceId;

	/*public Patient() 
	{
	}*/
	
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Patient(int patientId, int userId, String firstName, String lastName,String spouseName, Date dob, Date registrationDate, String gender, int height, int weight, String permnantAddress,
			String residentialAddress, String mobileNumber, String alternateNumber,String patientEmailId, String insuranceId,  Object verified) 
	{
		super();
		this.patientId = patientId;
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.spouseName = spouseName;
		this.dob = dob;
		this.registrationDate = registrationDate;
		this.gender = gender;
		this.height = height;
		this.weight=weight;
		this.permnantAddress = permnantAddress;
		this.residentialAddress = residentialAddress;
		this.mobileNumber = mobileNumber;
		this.alternateNumber = alternateNumber;
		this.patientEmailId=patientEmailId;
		this.insuranceId=insuranceId;
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
	
	public String getspouseName() {
		return spouseName;
	}
	public void setspouseName(String spouseName) {
		this.spouseName = spouseName;
	}

	public Date getregistrationDate() {
		return registrationDate;
	}
	public void setregistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}
	public void setGender(String gender)
	{
		this.gender = gender;
	}
	
	public int getheight() {
		return height;
	}
	public void setheight(int height) {
		this.height = height;
	}
	
	public int getweight() {
		return weight;
	}
	public void setweight(int weight) {
		this.weight = weight;
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
	
	public String getpatientEmailId() {
		return patientEmailId;
	}
	public void setpatientEmailId(String patientEmailId) {
		this.patientEmailId = patientEmailId;
	}
	
	public String getinsuranceId() {
		return insuranceId;
	}
	public void setgetinsuranceId(String insuranceId) {
		this.insuranceId = insuranceId;
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