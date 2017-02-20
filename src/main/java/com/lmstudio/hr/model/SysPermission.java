package com.lmstudio.hr.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the SYS_PERMISSION database table.
 * 
 */
@Entity
@Table(name="SYS_PERMISSION")
@NamedQuery(name="SysPermission.findAll", query="SELECT s FROM SysPermission s")
public class SysPermission implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Column(name="\"ACTION\"")
	private String action;

	private String description;

	@Column(name="\"LEVEL\"")
	private String level;

	@Column(name="PARENT_ID")
	private String parentId;

	@Column(name="\"TYPE\"")
	private String type;

	private String url;

	private String valid;

	public SysPermission() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAction() {
		return this.action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLevel() {
		return this.level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getParentId() {
		return this.parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getValid() {
		return this.valid;
	}

	public void setValid(String valid) {
		this.valid = valid;
	}

}