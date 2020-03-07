package com.ehr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ehr.model.Doctor;
import com.ehr.model.User;
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
	
	
	
	public Doctor findByUserId(int user_id) {
	     return doctorRepository.findByUserId(user_id);
	}
	
	@Transactional
	public List<Doctor> getAllDoctor() {
		return (List<Doctor>) doctorRepository.findAll();
	}
}
