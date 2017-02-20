package com.lmstudio.hr.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the SYS_ORG database table.
 * 
 */
@Entity
@Table(name="SYS_ORG")
@NamedQuery(name="SysOrg.findAll", query="SELECT s FROM SysOrg s")
public class SysOrg implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String name;

	@Column(name="PARENT_ID")
	private String parentId;

	@Column(name="SORT_NUM")
	private BigDecimal sortNum;

	private String valid;

	public SysOrg() {
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

	public String getParentId() {
		return this.parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public BigDecimal getSortNum() {
		return this.sortNum;
	}

	public void setSortNum(BigDecimal sortNum) {
		this.sortNum = sortNum;
	}

	public String getValid() {
		return this.valid;
	}

	public void setValid(String valid) {
		this.valid = valid;
	}

}