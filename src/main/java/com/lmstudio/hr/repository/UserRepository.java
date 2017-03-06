/**
* TODO
* @Project: hrapp
* @Title: UserRepository.java
* @Package com.lmstudio.hr.repository
* @author jason
* @Date 2017年3月6日 上午10:30:12
* @Copyright
* @Version 
*/
package com.lmstudio.hr.repository;

import java.util.List;

import com.lmstudio.hr.model.SysPermission;
import com.lmstudio.hr.model.SysUser;

/**
* TODO
* @ClassName: UserRepository
* @author jason
*/
public interface UserRepository {

	List<SysPermission> findPermissionsByUser(SysUser user);
}
