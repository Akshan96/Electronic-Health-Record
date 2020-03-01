package com.ehr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ehr.model.Doctor;
import com.ehr.repository.DoctorRepository;

@Service
public class DoctorService {
	private DoctorRepository doctorRepository;

	@Autowired
	public DoctorService(DoctorRepository doctorRepository) {
		this.doctorRepository = doctorRepository;
	}

	public void saveDoctor(Doctor doctor) {
		doctorRepository.save(doctor);
	}
}
