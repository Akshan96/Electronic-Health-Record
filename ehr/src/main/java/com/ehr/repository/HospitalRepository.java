package com.ehr.repository;

import com.ehr.model.Hospital;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long> {
    //Doctor findByUserId(int user_id);
}
