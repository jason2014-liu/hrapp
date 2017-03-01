/**
* TODO
* @Project: hrapp
* @Title: OrgController.java
* @Package com.lmstudio.hr.web
* @author jason
* @Date 2017年2月22日 上午10:03:13
* @Copyright
* @Version 
*/
package com.lmstudio.hr.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lmstudio.hr.model.SysOrg;
import com.lmstudio.hr.service.OrgService;

/**
* TODO
* @ClassName: OrgController
* @author jason
*/
@RequestMapping(value="/org")
@RestController
public class OrgController {

	@Autowired
	private OrgService orgService;
	
	@RequestMapping(value="/findAllOrg")
	public List<SysOrg> findAllOrg(){
		return orgService.findAllOrg();
	}
}
