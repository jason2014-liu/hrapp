package com.lmstudio.hr.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the REGIONS database table.
 * 
 */
public class Region implements Serializable {
	private static final long serialVersionUID = 1L;

	private BigDecimal regionId;

	private String regionName;

	public Region() {
	}

	public BigDecimal getRegionId() {
		return this.regionId;
	}

	public void setRegionId(BigDecimal regionId) {
		this.regionId = regionId;
	}

	public String getRegionName() {
		return this.regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

}