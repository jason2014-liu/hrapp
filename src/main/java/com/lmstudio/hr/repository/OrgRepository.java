/**
* TODO
* @Project: hrapp
* @Title: OrgRepository.java
* @Package com.lmstudio.hr.repository
* @author jason
* @Date 2017年2月20日 下午3:53:52
* @Copyright
* @Version 
*/
package com.lmstudio.hr.repository;

import java.util.List;

import com.lmstudio.hr.model.SysOrg;

/**
* TODO
* @ClassName: OrgRepository
* @author jason
*/
public interface OrgRepository {

	void saveOrg(SysOrg org);
	
	List<SysOrg> findAllOrg();
	
	SysOrg findById(String Id);
}
