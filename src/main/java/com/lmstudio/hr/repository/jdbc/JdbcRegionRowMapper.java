/**
* TODO
* @Project: hrapp
* @Title: JdbcRegionRowMapper.java
* @Package com.lmstudio.hr.repository.jdbc
* @author jason
* @Date 2017年2月14日 下午2:39:23
* @Copyright
* @Version 
*/
package com.lmstudio.hr.repository.jdbc;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.lmstudio.hr.model.Region;

/**
* TODO
* @ClassName: JdbcRegionRowMapper
* @author jason
*/
public class JdbcRegionRowMapper implements RowMapper<Region> {

	@Override
	public Region mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Region region = new Region();
		String regionId = rs.getString("REGION_ID");
		if(regionId != null){
			region.setRegionId(BigDecimal.valueOf(Long.valueOf(regionId)));
		}
		region.setRegionName(rs.getString("REGION_NAME"));
		return region;
	}

}
