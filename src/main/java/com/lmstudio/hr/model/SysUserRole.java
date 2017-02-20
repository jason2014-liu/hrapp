package com.lmstudio.hr.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the SYS_USER_ROLE database table.
 * 
 */
@Entity
@Table(name="SYS_USER_ROLE")
@NamedQuery(name="SysUserRole.findAll", query="SELECT s FROM SysUserRole s")
public class SysUserRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	@Column(name="ROLE_ID")
	private String roleId;

	@Column(name="USER_ID")
	private String userId;

	public SysUserRole() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}