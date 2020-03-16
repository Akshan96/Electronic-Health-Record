package com.ehr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ehr.model.Consultation;

@Repository
public interface ConsultationRepository extends JpaRepository<Consultation, Long>{

	List<Consultation> findAllByPatientId(int patient_id);
	
	@Query(value = "SELECT c.*, d.first_name, d.last_name FROM ehr.consultation as c INNER JOIN ehr.doctor as d ON c.doctor_id = d.doctor_id where patient_id = ?1", nativeQuery = true)
	List<Object> findAllDetailsWithDoctorInfoByPatientId(int patient_id);

}

