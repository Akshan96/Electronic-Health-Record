package com.ehr.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "medical_history")
public class MedicalHistory 
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MedicalHistory_Id")
    private int medicalhistoryId;
    
    @Column(name = "patient_id")
    private int patientId;
    
    @Column(name = "userId")
    private int userId;
   
   
	@Column(name="date_insert", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateInsert;
    
    @Column(name = "Chief_Complaint_CC")
	private String CC;
    
	@Column(name = "History_of_present_illness_HPL")
	private String HPI;
    
    @Column(name = "Past_medical_histor_PMH")
	private String PMH;
    
    @Column(name = "Review_of_organ_system_ROS")
	private String ROS;
    
    @Column(name = "Family_diseases_FD")
	private String FD;
    
    @Column(name = "Childhood_diseases_CD")
	private String CD;
    
    @Column(name = "Allergeies")
   	private String allergies;
    
    @Column(name = "Is_Diabetic")
   	private Boolean isDiabetic;
    
    @Column(name = "PrescribeMedicine_PM")
   	private String PM;
    
    /**
	 * @return the medicalhistoryId
	 */
	public int getMedicalhistoryId() {
		return medicalhistoryId;
	}

	/**
	 * @param medicalhistoryId the medicalhistoryId to set
	 */
	public void setMedicalhistoryId(int medicalhistoryId) {
		this.medicalhistoryId = medicalhistoryId;
	}

	/**
	 * @return the patientId
	 */
	public int getPatientId() {
		return patientId;
	}

	/**
	 * @param patientId the patientId to set
	 */
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return the dateInsert
	 */
	public Date getDateInsert() {
		return dateInsert;
	}

	/**
	 * @param dateInsert the dateInsert to set
	 */
	public void setDateInsert(Date dateInsert) {
		this.dateInsert = dateInsert;
	}

	/**
	 * @return the cC
	 */
	public String getCC() {
		return CC;
	}

	/**
	 * @param cC the cC to set
	 */
	public void setCC(String cC) {
		CC = cC;
	}

	/**
	 * @return the hPI
	 */
	public String getHPI() {
		return HPI;
	}

	/**
	 * @param hPI the hPI to set
	 */
	public void setHPI(String hPI) {
		HPI = hPI;
	}

	/**
	 * @return the pMH
	 */
	public String getPMH() {
		return PMH;
	}

	/**
	 * @param pMH the pMH to set
	 */
	public void setPMH(String pMH) {
		PMH = pMH;
	}

	/**
	 * @return the rOS
	 */
	public String getROS() {
		return ROS;
	}

	/**
	 * @param rOS the rOS to set
	 */
	public void setROS(String rOS) {
		ROS = rOS;
	}

	/**
	 * @return the fD
	 */
	public String getFD() {
		return FD;
	}

	/**
	 * @param fD the fD to set
	 */
	public void setFD(String fD) {
		FD = fD;
	}

	/**
	 * @return the cD
	 */
	public String getCD() {
		return CD;
	}

	/**
	 * @param cD the cD to set
	 */
	public void setCD(String cD) {
		CD = cD;
	}

	/**
	 * @return the allergies
	 */
	public String getAllergies() {
		return allergies;
	}

	/**
	 * @param allergies the allergies to set
	 */
	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}

	/**
	 * @return the isDiabetic
	 */
	public Boolean getIsDiabetic() {
		return isDiabetic;
	}

	/**
	 * @param isDiabetic the isDiabetic to set
	 */
	public void setIsDiabetic(Boolean isDiabetic) {
		this.isDiabetic = isDiabetic;
	}

	/**
	 * @return the pM
	 */
	public String getPM() {
		return PM;
	}

	/**
	 * @param pM the pM to set
	 */
	public void setPM(String pM) {
		PM = pM;
	}
    
   

}
