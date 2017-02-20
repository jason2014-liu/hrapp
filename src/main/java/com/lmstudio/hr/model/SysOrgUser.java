package com.lmstudio.hr.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the SYS_ORG_USER database table.
 * 
 */
@Entity
@Table(name="SYS_ORG_USER")
@NamedQuery(name="SysOrgUser.findAll", query="SELECT s FROM SysOrgUser s")
public class SysOrgUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	@Temporal(TemporalType.DATE)
	@Column(name="END_DATE")
	private Date endDate;

	@Column(name="ORG_ID")
	private String orgId;

	@Column(name="POSITION_CODE")
	private String positionCode;

	@Column(name="POSITION_NAME")
	private String positionName;

	@Temporal(TemporalType.DATE)
	@Column(name="START_DATE")
	private Date startDate;

	@Column(name="USER_ID")
	private String userId;

	private String valid;

	public SysOrgUser() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getOrgId() {
		return this.orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getPositionCode() {
		return this.positionCode;
	}

	public void setPositionCode(String positionCode) {
		this.positionCode = positionCode;
	}

	public String getPositionName() {
		return this.positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getValid() {
		return this.valid;
	}

	public void setValid(String valid) {
		this.valid = valid;
	}

}