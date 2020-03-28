package com.ehr.repository;

import com.ehr.model.PermissionActionAudit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionActionAuditRepository extends JpaRepository<PermissionActionAudit, Long> {
}

