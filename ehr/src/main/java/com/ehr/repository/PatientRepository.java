package com.ehr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ehr.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

	Patient findByUserId(int userId);
    Patient findByPatientId(int patientId);

}
