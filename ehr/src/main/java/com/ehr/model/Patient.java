package com.ehr.model;

import javax.persistence.*;

@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "patient_id")
    private int id;
    
	@OneToOne
    @JoinColumn(name = "userId", nullable = true)
    private User patient;
    

}
