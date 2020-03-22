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
       
    @Column(name = "patient_id")
    private int patientId;
	
	@Column(name = "company_name")
	private String companyName;	
	
	@Column(name = "max_claim_amount")
	private String maxClaimAmout;	
	
	public int getInsuranceId() {
		return insuranceId;
	}

	public void setInsuranceId(int insuranceId) {
		this.insuranceId = insuranceId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getMaxClaimAmout() {
		return maxClaimAmout;
	}

	public void setMaxClaimAmout(String maxClaimAmout) {
		this.maxClaimAmout = maxClaimAmout;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	@Column(name = "issue_date")
	private Date issueDate;

	@Column(name = "expiry_date")
	private Date expiryDate;

	
	public Insurance() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Insurance(int insuranceId, int patientId, String companyName, String maxClaimAmout,  Date issueDate, Date expiryDate) {
		super();
		this.insuranceId = insuranceId;
		this.patientId = patientId;
		this.companyName = companyName;
		this.issueDate = issueDate;
		this.expiryDate = expiryDate;
		this.maxClaimAmout = maxClaimAmout;
		
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

	public String getcompanyName() {
		return companyName;
	}

	public void setcompanyName(String companyName) {
		this.companyName = companyName;
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
	
}