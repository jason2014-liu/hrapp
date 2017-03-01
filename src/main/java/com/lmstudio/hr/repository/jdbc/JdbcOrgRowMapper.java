/**
* TODO
* @Project: hrapp
* @Title: JdbcOrgRowMapper.java
* @Package com.lmstudio.hr.repository.jdbc
* @author jason
* @Date 2017年2月21日 下午4:18:19
* @Copyright
* @Version 
*/
package com.lmstudio.hr.repository.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.lmstudio.hr.model.SysOrg;

/**
* TODO
* @ClassName: JdbcOrgRowMapper
* @author jason
*/
public class JdbcOrgRowMapper implements RowMapper<SysOrg> {

	@Override
	public SysOrg mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		SysOrg org = new SysOrg();
		org.setId(rs.getString("ID"));
		org.setName(rs.getString("NAME"));
		org.setParentId(rs.getString("PARENT_ID"));
		org.setValid(rs.getString("VALID"));
		org.setSortNum(rs.getBigDecimal("SORT_NUM"));
		return org;
	}

}
