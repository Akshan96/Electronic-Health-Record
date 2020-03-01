package com.ehr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ehr.model.Doctor;
import com.ehr.model.Hospital;
import com.ehr.repository.DoctorRepository;
import com.ehr.repository.HospitalRepository;

@Service
public class HospitalService {
	private HospitalRepository hospitalRepository;

	@Autowired
	public HospitalService(HospitalRepository hospitalRepository) {
		this.hospitalRepository = hospitalRepository;
	}

	public void saveHospital(Hospital hospital) {
		hospitalRepository.save(hospital);
	}
}
