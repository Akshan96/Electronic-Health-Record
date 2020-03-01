package com.ehr.model;

import javax.persistence.*;

@Entity
@Table(name = "hospital")
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "hospital_id")
    private int id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "phoneNumber")
    private String phoneNumber;
    
    public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
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


	public User getHospital() {
		return hospital;
	}


	public void setHospital(User hospital) {
		this.hospital = hospital;
	}


	@Column(name = "address")
    private String address;
    
    
	@OneToOne
    @JoinColumn(name = "user_id", nullable = true)
    private User hospital;
    

}
