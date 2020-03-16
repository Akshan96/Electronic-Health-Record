package com.ehr.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ehr.model.Consultation;
import com.ehr.model.Doctor;
import com.ehr.repository.ConsultationRepository;

@Service
public class ConsultationService {
	
	private ConsultationRepository consultationRepository;
	
	@Autowired
	public ConsultationService(ConsultationRepository consultationRepository) {
		this.consultationRepository = consultationRepository;
	}

	public void saveConsultation(Consultation consultation) {
		consultationRepository.save(consultation);
	}	
	
	@Transactional
	public List<Consultation> getAllConsultation() {
		return (List<Consultation>) consultationRepository.findAll();
	}

	public List<Consultation> findAll() {
		return consultationRepository.findAll();
	}

	public Optional<Consultation> findById(Long id) {
		return consultationRepository.findById(id);
	}
	
	public List<Consultation> findAllByPatientId(int patient_id) {
	     return consultationRepository.findAllByPatientId(patient_id);
	}
	
	public List<Object> findAllDetailsWithDoctorInfoByPatientId(int patient_id) {
	     return consultationRepository.findAllDetailsWithDoctorInfoByPatientId(patient_id);
	}
	
}
