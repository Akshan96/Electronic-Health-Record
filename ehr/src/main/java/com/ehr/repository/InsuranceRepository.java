package com.ehr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ehr.model.Insurance;
import com.ehr.model.Patient;

@Repository
public interface InsuranceRepository extends JpaRepository<Insurance, Long> {

	//Patient findByUserId(int userId);
    Insurance findByPatientId(int patientId);

}
