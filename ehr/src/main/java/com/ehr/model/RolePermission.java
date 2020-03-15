package com.ehr.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "role_permission")
public class RolePermission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
	@Column(name = "userId")
    private int userId;
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
 
	@Column(name="permissions")
	@ElementCollection(targetClass=EnumPermission.class)
	private List<EnumPermission> enumPermissions;
	public List<EnumPermission> getEnumPermissions() {
		return enumPermissions;
	}
	public void setEnumPermissions(List<EnumPermission> enumPermissions) {
		this.enumPermissions = enumPermissions;
	}
    
    
}
