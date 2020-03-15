package com.ehr.repository;

import com.ehr.model.RolePermission;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolePermissionRepository extends JpaRepository<RolePermission, Long> {
    RolePermission findByUserId(int user_id);
}
