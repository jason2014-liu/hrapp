/**
* TODO
* @Project: hrapp
* @Title: HelloController.java
* @Package com.lmstudio.hr.controller
* @author jason
* @Date 2017年2月13日 下午2:20:48
* @Copyright
* @Version 
*/
package com.lmstudio.hr.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lmstudio.hr.model.Region;
import com.lmstudio.hr.service.RegionService;

/**
* TODO
* @ClassName: HelloController
* @author jason
*/
@Controller
public class HelloController {
	
	@Autowired
	private RegionService regionService;

	@RequestMapping(value="/hello/echo")
	@ResponseBody
	public String echo(){
		return "hello,Spring Boot";
	}
	
	@RequestMapping(value="/hello")
	public String hello(ModelMap map){
		map.addAttribute("address", "中国");
		return "hello";
	}
	
	@RequestMapping(value="/hello/getAllRegions")
	@ResponseBody
	public List<Region> getAllRegions(){
		return regionService.getAllRegions();
	}
}
