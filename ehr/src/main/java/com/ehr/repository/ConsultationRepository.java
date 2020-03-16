package com.ehr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ehr.model.Consultation;

@Repository
public interface ConsultationRepository extends JpaRepository<Consultation, Long>{

	List<Consultation> findAllByPatientId(int patient_id);

}
