/**
* TODO
* @Project: hrapp
* @Title: OrgServiceImpl.java
* @Package com.lmstudio.hr.service
* @author jason
* @Date 2017年2月22日 上午9:59:44
* @Copyright
* @Version 
*/
package com.lmstudio.hr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lmstudio.hr.model.SysOrg;
import com.lmstudio.hr.repository.OrgRepository;

/**
* TODO
* @ClassName: OrgServiceImpl
* @author jason
*/
@Service
public class OrgServiceImpl implements OrgService{
	
	@Autowired
	private OrgRepository orgReporsitory;

	@Cacheable(value="orgCache",keyGenerator="jasonKeyGenerator")
	@Override
	public List<SysOrg> findAllOrg() {
		// TODO Auto-generated method stub
		return orgReporsitory.findAllOrg();
	}

	//@Cacheable(value="demo",key="#id+'findOrgById'")
	@Override
	public SysOrg findOrgById(String id) {
		// TODO Auto-generated method stub
		return orgReporsitory.findById(id);
	}

	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
	@Override
	public void saveOrg(SysOrg org) {
		// TODO Auto-generated method stub
		orgReporsitory.saveOrg(org);
	}

}
