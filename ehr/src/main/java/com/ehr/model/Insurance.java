package com.ehr.model;

import java.sql.Date;

import javax.persistence.*;

@Entity	
@Table(name = "insurance")
public class Insurance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "insurance_id")
    private int insuranceId;
    
    public boolean isVerified() {
		return isVerified();
	}

	public void setVerified(boolean verified) {
	}
    
    @Column(name = "patient_id")
    private int patientId;
    
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "gender")
	private String gender;
	
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
	
	@Column(name = "company_name")
	private String companyName;	
	
	@Column(name = "issue_date")
	private Date issueDate;

	@Column(name = "expiry_date")
	private Date expiryDate;

	
	public Insurance() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Insurance(int insuranceId, int patientId, String firstName, String lastName, Date dob,
			String gender, String permnantAddress, String residentialAddress, String mobileNumber, String alternateNumber, String companyName,  Date issueDate, Date expiryDate) {
		super();
		this.insuranceId = insuranceId;
		this.patientId = patientId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.gender = gender;
		this.permnantAddress = permnantAddress;
		this.residentialAddress = residentialAddress;
		this.mobileNumber = mobileNumber;
		this.alternateNumber = alternateNumber;
		this.companyName = companyName;
		this.issueDate = issueDate;
		this.expiryDate = expiryDate;
		
	}

	public int getinsuranceId() {
		return insuranceId;
	}

	public void setinsuranceId(int insuranceId) {
		this.insuranceId = insuranceId;
	}
	
	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
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

	public String getcompanyName() {
		return companyName;
	}

	public void setcompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Date getissueDate() {
		return issueDate;
	}

	public void setissueDate(Date issueDate) {
		this.issueDate = issueDate;
	}
	
	public Date getexpiryDate() {
		return expiryDate;
	}

	public void setexpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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