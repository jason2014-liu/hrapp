/**
* TODO
* @Project: hrapp
* @Title: UserServiceImpl.java
* @Package com.lmstudio.hr.service
* @author jason
* @Date 2017年3月6日 上午11:04:13
* @Copyright
* @Version 
*/
package com.lmstudio.hr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lmstudio.hr.model.SysPermission;
import com.lmstudio.hr.model.SysUser;
import com.lmstudio.hr.repository.UserRepository;

/**
* TODO
* @ClassName: UserServiceImpl
* @author jason
*/
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<SysPermission> findPermissions(SysUser user) {
		// TODO Auto-generated method stub
		return userRepository.findPermissionsByUser(user);
	}

}
