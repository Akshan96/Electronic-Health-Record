package com.ehr.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "role_permission")
public class RolePermission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
	@Column(name = "userId")
    private int userId;
	@Column(name = "medical_history")
    private boolean medicalHistory;
	@Column(name = "insurence")
    private boolean insurence;
	@Column(name = "patient_info")
    private boolean patientInfo;
	@Column(name = "consultation")
    private boolean consultation;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
