package com.ehr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ehr.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

	Patient findByUserId(int userId);

}
