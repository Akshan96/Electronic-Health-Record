package com.ehr.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ehr.model.MedicalHistory;
import com.ehr.repository.MedicalHistoryRepository;

@Service
public class MedicalHistoryService {
	
	@Autowired
	MedicalHistoryRepository MedicalHistoryRepository;
	
	//@Transactional
	public List<MedicalHistory> getAllMedicalHistory() {
		return (List<MedicalHistory>) MedicalHistoryRepository.findAll();
	}
		
	public Optional<MedicalHistory> getMedicalHistory(Long medicalhistoryId) {
		System.out.println("serviceData2: "+MedicalHistoryRepository.findById(medicalhistoryId));
		return MedicalHistoryRepository.findById(medicalhistoryId);
	}
	
	public void savePatient(MedicalHistory MedicalHistory) {
		MedicalHistoryRepository.save(MedicalHistory);
	}

	//public MedicalHistory findByUserId(int patientId) {
		//return MedicalHistoryRepository.findByUserId(patientId);
	//}
	
    public MedicalHistory findById(int patientId) {
        return MedicalHistoryRepository.findByPatientId(patientId);
    }
	
}
