package com.ehr.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ehr.model.Consultation;
import com.ehr.model.Doctor;
import com.ehr.model.Insurance;
import com.ehr.repository.ConsultationRepository;
import com.ehr.repository.InsuranceRepository;

@Service
public class InsurenceService {
	
	private InsuranceRepository insuranceRepository;
	
	@Autowired
	public InsurenceService(InsuranceRepository insuranceRepository) {
		this.insuranceRepository = insuranceRepository;
	}

	public void saveInsurence(Insurance insurance) {
		insuranceRepository.save(insurance);
	}	
	
	public Insurance getInsurenceByPatientId(int patientId) {
		return insuranceRepository.findByPatientId(patientId);
	}

	
}
