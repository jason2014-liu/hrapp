/**
* TODO
* @Project: hrapp
* @Title: OrgService.java
* @Package com.lmstudio.hr.service
* @author jason
* @Date 2017年2月22日 上午9:57:58
* @Copyright
* @Version 
*/
package com.lmstudio.hr.service;

import java.util.List;

import com.lmstudio.hr.model.SysOrg;

/**
* TODO
* @ClassName: OrgService
* @author jason
*/
public interface OrgService {

	List<SysOrg> findAllOrg();
	
	SysOrg findOrgById(String id);
	
	void saveOrg(SysOrg org);
}
