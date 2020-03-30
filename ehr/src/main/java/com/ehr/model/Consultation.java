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
import javax.persistence.Transient;

@Entity
@Table(name = "consultation")
public class Consultation {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "consultation_id")
	private int id;
	    
	@Column(name = "consult_comment")
    private String consultComment;
    
    @Column(name = "doctor_id")
    private int doctorId;
    
    @Column(name = "patient_id")
    private int patientId;
    
    @Column(name="date_insert", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateInsert;
    
    @Transient
    private String DoctorName;
    
	public String getDoctorName() {
		return DoctorName;
	}

	public void setDoctorName(String doctorName) {
		DoctorName = doctorName;
	}

	public Consultation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Consultation(int id, String consultComment, int doctorId, int patientId, Date dateInsert,
			boolean verified) {
		super();
		this.id = id;
		this.consultComment = consultComment;
		this.doctorId = doctorId;
		this.patientId = patientId;
		this.dateInsert = dateInsert;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getConsultComment() {
		return consultComment;
	}

	public void setConsultComment(String consultComment) {
		this.consultComment = consultComment;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public Date getDateInsert() {
		return dateInsert;
	}

	public void setDateInsert(Date dateInsert) {
		this.dateInsert = dateInsert;
	}


}
