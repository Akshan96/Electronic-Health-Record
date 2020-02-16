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
    
    @Column(name = "address")
    private String address;
    
    
	@OneToOne
    @JoinColumn(name = "user_id", nullable = true)
    private User hospital;
    

}
