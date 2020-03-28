package com.ehr.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "permission_action_audit")
public class PermissionActionAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
	@Column(name = "modifiedBy")
    private int modifiedBy;
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	@Column(name = "medical_history")
    private boolean medicalHistory;
	@Column(name = "insurence")
    private boolean insurence;
	@Column(name = "patient_info")
    private boolean patientInfo;
	@Column(name = "consultation")
    private boolean consultation;
	@Column(name = "time_stamp")
    private Date timeStamp;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(int modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public boolean isMedicalHistory() {
		return medicalHistory;
	}
	public void setMedicalHistory(boolean medicalHistory) {
		this.medicalHistory = medicalHistory;
	}
	public boolean isInsurence() {
		return insurence;
	}
	public void setInsurence(boolean insurence) {
		this.insurence = insurence;
	}
	public boolean isPatientInfo() {
		return patientInfo;
	}
	public void setPatientInfo(boolean patientInfo) {
		this.patientInfo = patientInfo;
	}
	public boolean isConsultation() {
		return consultation;
	}
	public void setConsultation(boolean consultation) {
		this.consultation = consultation;
	}

 
	
    
}
