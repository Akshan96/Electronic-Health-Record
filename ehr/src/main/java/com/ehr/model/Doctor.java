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
    
    @Column(name = "firstName")
    private String firstName;
    
    @Column(name = "lastName")
    private String lastName;
    
    @Column(name = "dob")
    private Date dob;
    
    @Column(name = "phoneNumber")
    private String phoneNumber;
    
    @Column(name = "address")
    private String address;
    
    @Column(name = "speciality")
    private String speciality;
    
    @Column(name = "experience")
    private String experience;
    
    
    
    
	@OneToOne
    @JoinColumn(name = "user_id", nullable = true)
    private User doctor;
    

}
