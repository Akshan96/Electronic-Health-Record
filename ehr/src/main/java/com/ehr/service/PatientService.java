package com.ehr.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ehr.model.Patient;
import com.ehr.repository.PatientRepository;

@Service
public class PatientService {
	
	@Autowired
	PatientRepository patientRepository;
	
//	public List<Patient> getAllPatients(){
//		List<Patient> listOfPatients = new ArrayList();
//		listOfPatients = patientRepository.findAll();
//		System.out.println("serviceData: "+listOfPatients);
//		return listOfPatients;
//	}
	
	@Transactional
	public List<Patient> getAllPatients() {
		return (List<Patient>) patientRepository.findAll();
	}
		
	public Optional<Patient> getPatient(Long patientID) {
		
		System.out.println("serviceData2: "+patientRepository.findById(patientID));
		return patientRepository.findById(patientID);
	}
	
	public void savePatient(Patient patinet) {
		patientRepository.save(patinet);
	}

	public Patient findByUserId(int userId) {
		// TODO Auto-generated method stub
		return patientRepository.findByUserId(userId);
	}

	

	
	
	
}
