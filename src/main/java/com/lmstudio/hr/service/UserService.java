/**
* TODO
* @Project: hrapp
* @Title: UserService.java
* @Package com.lmstudio.hr.service
* @author jason
* @Date 2017年3月6日 上午10:27:23
* @Copyright
* @Version 
*/
package com.lmstudio.hr.service;

import java.util.List;

import com.lmstudio.hr.model.SysPermission;
import com.lmstudio.hr.model.SysUser;

/**
* TODO
* @ClassName: UserService
* @author jason
*/
public interface UserService {

	List<SysPermission> findPermissions(SysUser user);
}
