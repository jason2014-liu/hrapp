package com.lmstudio.hr.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the SYS_ROLE_PERMISSION database table.
 * 
 */
@Entity
@Table(name="SYS_ROLE_PERMISSION")
@NamedQuery(name="SysRolePermission.findAll", query="SELECT s FROM SysRolePermission s")
public class SysRolePermission implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	@Column(name="PEMISSION_ID")
	private String pemissionId;

	@Column(name="ROLE_ID")
	private String roleId;

	public SysRolePermission() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPemissionId() {
		return this.pemissionId;
	}

	public void setPemissionId(String pemissionId) {
		this.pemissionId = pemissionId;
	}

	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

}