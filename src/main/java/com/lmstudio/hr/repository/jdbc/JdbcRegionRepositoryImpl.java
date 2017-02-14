/**
* TODO
* @Project: hrapp
* @Title: JdbcRegionRepositoryImpl.java
* @Package com.lmstudio.hr.repository.jdbc
* @author jason
* @Date 2017年2月13日 下午4:46:29
* @Copyright
* @Version 
*/
package com.lmstudio.hr.repository.jdbc;

import java.util.HashMap;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lmstudio.hr.model.Region;
import com.lmstudio.hr.repository.RegionRepository;

/**
 * TODO
 * 
 * @ClassName: JdbcRegionRepositoryImpl
 * @author jason
 */
@Repository
public class JdbcRegionRepositoryImpl implements RegionRepository {

	private NamedParameterJdbcTemplate namedJdbcTemplate;

	@Autowired
	public JdbcRegionRepositoryImpl(DataSource dataSource) {
		namedJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public List<Region> getAllRegion() {
		// TODO Auto-generated method stub
		return namedJdbcTemplate.query("select REGION_ID,REGION_NAME from HR.REGIONS", new HashMap<String, Object>(),
				new JdbcRegionRowMapper());
	}

}
