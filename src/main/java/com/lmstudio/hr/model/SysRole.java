package com.lmstudio.hr.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the SYS_ROLE database table.
 * 
 */
@Entity
@Table(name="SYS_ROLE")
@NamedQuery(name="SysRole.findAll", query="SELECT s FROM SysRole s")
public class SysRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String name;

	public SysRole() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}