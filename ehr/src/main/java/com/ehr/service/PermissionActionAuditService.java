package com.ehr.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ehr.model.MedicalHistory;
import com.ehr.model.PermissionActionAudit;
import com.ehr.repository.MedicalHistoryRepository;
import com.ehr.repository.PermissionActionAuditRepository;

@Service
public class PermissionActionAuditService {
	
	@Autowired
	PermissionActionAuditRepository actionAuditRepository;
	
	
	public void savePermissionActionAudit(PermissionActionAudit permissionActionAudit) {
		actionAuditRepository.save(permissionActionAudit);
	}
	
}
