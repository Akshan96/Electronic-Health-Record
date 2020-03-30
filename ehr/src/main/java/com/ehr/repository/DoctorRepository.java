package com.ehr.repository;

import com.ehr.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
   Doctor findByUserId(int userId);
   Doctor findById(int id);
}
