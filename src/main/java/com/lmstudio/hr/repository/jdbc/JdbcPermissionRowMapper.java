package com.lmstudio.hr.repository.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.lmstudio.hr.model.SysPermission;

public class JdbcPermissionRowMapper implements RowMapper<SysPermission> {

	@Override
	public SysPermission mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		SysPermission permission = new SysPermission();
		permission.setId(rs.getString("ID"));
		permission.setDescription(rs.getString("DESCRIPTION"));
		permission.setUrl(rs.getString("URL"));
		permission.setParentId(rs.getString("PARENT_ID"));
		return permission;
	}

}
