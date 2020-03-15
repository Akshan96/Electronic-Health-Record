package com.ehr.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "doctor_id")
    private int id;
    
    public boolean isVerified() {
		return verified;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}

	@Column(name = "firstName")
    private String firstName;
    
    @Column(name = "lastName")
    private String lastName;
    
    @Column(name = "userId")
    private int userId;
    
    public Doctor(int id, String firstName, String lastName, int userId, boolean verified, String dob, String phoneNumber,
			String address, String speciality, String experience) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userId = userId;
		this.verified = verified;
		this.dob = dob;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.speciality = speciality;
		this.experience = experience;
	}

	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Column(name="verified")
    private boolean verified = false;
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getDob() {
		return dob;
	}

	public void setDob(String string) {
		this.dob = string;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Column(name = "dob")
    private String dob;
    
    @Column(name = "phoneNumber")
    private String phoneNumber;
    
    @Column(name = "address")
    private String address;
    
    @Column(name = "speciality")
    private String speciality;
    
    @Column(name = "experience")
    private String experience;
    

}
