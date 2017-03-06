/**
* TODO
* @Project: hrapp
* @Title: JdbcOrgRePositoryImpl.java
* @Package com.lmstudio.hr.repository.jdbc
* @author jason
* @Date 2017年2月21日 上午11:58:27
* @Copyright
* @Version 
*/
package com.lmstudio.hr.repository.jdbc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lmstudio.hr.model.SysOrg;
import com.lmstudio.hr.repository.OrgRepository;

/**
* TODO
* @ClassName: JdbcOrgRePositoryImpl
* @author jason
*/
@Repository
public class JdbcOrgRepositoryImpl implements OrgRepository {

	private NamedParameterJdbcTemplate namedJdbcTemplate;
	
	@Autowired
	public JdbcOrgRepositoryImpl(DataSource dataSource) {
		this.namedJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	String SQL_INSERTORG = "insert into sys_org(id,name,parent_id,valid,sort_num) values(:id,:name,:parentId,:valid,:sortNum)";
	String SQL_FINDALL = "select id,name,parent_id,valid,sort_num from sys_org";
	String SQL_FINDORGBYID = "select id,name,parent_id,valid,sort_num from sys_org　where id = :id";
	
	@Override
	public void saveOrg(SysOrg org) {
		// TODO Auto-generated method stub

		KeyHolder keyHolder = new GeneratedKeyHolder();
		namedJdbcTemplate.update(SQL_INSERTORG, new BeanPropertySqlParameterSource(org), keyHolder);
		int key = keyHolder.getKey().intValue();
		org.setId(String.valueOf(key));
	}

	@Transactional(readOnly=true)
	@Override
	public List<SysOrg> findAllOrg() {
		// TODO Auto-generated method stub
		return namedJdbcTemplate.query(SQL_FINDALL, new JdbcOrgRowMapper());
	}

	@Override
	public SysOrg findById(String id) {
		// TODO Auto-generated method stub
		
		Map<String,String> params = new HashMap<String, String>();
		params.put("id", id);
		return namedJdbcTemplate.queryForObject(SQL_FINDORGBYID, params, new JdbcOrgRowMapper());
	}

}
