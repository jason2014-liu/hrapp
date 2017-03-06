/**
* TODO
* @Project: hrapp
* @Title: JdbcUserRepository.java
* @Package com.lmstudio.hr.repository.jdbc
* @author jason
* @Date 2017年3月6日 上午10:32:00
* @Copyright
* @Version 
*/
package com.lmstudio.hr.repository.jdbc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lmstudio.hr.model.SysPermission;
import com.lmstudio.hr.model.SysUser;
import com.lmstudio.hr.repository.UserRepository;

/**
 * TODO
 * 
 * @ClassName: JdbcUserRepository
 * @author jason
 */
@Repository
public class JdbcUserRepositoryImpl implements UserRepository {

	private NamedParameterJdbcTemplate namedJdbcTemplate;

	String SQL_FINDPERMISSIONSBYUSER = "select sp.*"
	+" from sys_user_role sur,"
	+" sys_role_permission srp, sys_permission"
	+" sp where sp.id="
	+" srp.pemission_id and srp.role_id="
	+" sur.role_id and sur.user_id= :userid";

	@Autowired
	public JdbcUserRepositoryImpl(DataSource dataSource) {
		this.namedJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public List<SysPermission> findPermissionsByUser(SysUser user) {
		// TODO Auto-generated method stub
		Map<String,String> params = new HashMap<String,String>();
		params.put("userid", user.getId());
		return namedJdbcTemplate.query(SQL_FINDPERMISSIONSBYUSER, params, new JdbcPermissionRowMapper());
	}

}
