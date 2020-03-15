package com.ehr.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ehr.model.RolePermission;
import com.ehr.repository.RolePermissionRepository;

@Service
public class RolePermissionService {
	private RolePermissionRepository permissionRepository;

	@Autowired
	public RolePermissionService(RolePermissionRepository permissionRepository) {
		this.permissionRepository = permissionRepository;
	}

	public void savePermission(RolePermission rolePermission) {
		permissionRepository.save(rolePermission);
	}



	public RolePermission findByUserId(int user_id) {
		return permissionRepository.findByUserId(user_id);
	}
}
