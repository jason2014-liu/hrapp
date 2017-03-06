/**
* TODO
* @Project: hrapp
* @Title: UserController.java
* @Package com.lmstudio.hr.web
* @author jason
* @Date 2017年3月6日 上午10:24:16
* @Copyright
* @Version 
*/
package com.lmstudio.hr.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.lmstudio.hr.model.SysPermission;
import com.lmstudio.hr.model.SysUser;
import com.lmstudio.hr.service.UserService;
import com.lmstudio.hr.vo.ZTreeNode;

/**
* TODO
* @ClassName: UserController
* @author jason
*/
@Controller
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value="/login")
	public String login(){
		
		return "index2";
	}
	
	@RequestMapping(value= "/getMenus", method=RequestMethod.POST)
	@ResponseBody
	public List<ZTreeNode> getMenus(){
		SysUser user = new SysUser();
		user.setId("100");
		List<SysPermission> permissions = userService.findPermissions(user);
		
		List<ZTreeNode> nodes = null;
		ZTreeNode node = null;
		if(permissions != null){
			nodes = new ArrayList<ZTreeNode>();
			for(SysPermission permission : permissions){
				node = new ZTreeNode();
				node.setId(permission.getId());
				node.setName(permission.getDescription());
				node.setpId(permission.getParentId());
				node.setHref(permission.getUrl());
				node.setOpen(true);
				
				nodes.add(node);
			}
		}
		return nodes;
	}
}
