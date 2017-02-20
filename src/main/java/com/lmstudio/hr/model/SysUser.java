package com.lmstudio.hr.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the SYS_USER database table.
 * 
 */
@Entity
@Table(name="SYS_USER")
@NamedQuery(name="SysUser.findAll", query="SELECT s FROM SysUser s")
public class SysUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Column(name="LOGIN_NAME")
	private String loginName;

	private String name;

	private String password;

	private String valid;

	public SysUser() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLoginName() {
		return this.loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getValid() {
		return this.valid;
	}

	public void setValid(String valid) {
		this.valid = valid;
	}

}