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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lmstudio.hr.model.SysOrg;
import com.lmstudio.hr.model.SysPermission;
import com.lmstudio.hr.service.OrgService;
import com.lmstudio.hr.web.vo.DataGridVo;
import com.lmstudio.hr.web.vo.ZTreeNode;

/**
* TODO
* @ClassName: OrgController
* @author jason
*/
@RequestMapping(value="/org")
@Controller
public class OrgController { 
	private static final Logger logger = LoggerFactory.getLogger(OrgController.class);

	@Autowired
	private OrgService orgService;
	
	@RequestMapping(value="/findAllOrg")
	@ResponseBody
	public List<SysOrg> findAllOrg(){
		return orgService.findAllOrg();
	}
	
	@RequestMapping(value="/findOrgByPage")
	@ResponseBody
	public DataGridVo findOrgByPage(HttpServletRequest request,SysOrg form,@RequestParam("page")int page,@RequestParam("rows")int rows){
		
		printRequestParams(request);
		
		List<SysOrg> list =  orgService.findAllOrg();
		DataGridVo<SysOrg> dg = new DataGridVo<SysOrg>();
		dg.setRows(list);
		dg.setTotal(7);
		return dg;
	}
	
	@RequestMapping(value="/toOrgListPage")
	public String toOrgListPage(){
		return "orgList";
	}
	
	@RequestMapping(value="/getOrgs")
	@ResponseBody
	public List<ZTreeNode> getOrgs(){
		
		List<SysOrg> list =  orgService.findAllOrg();
		List<ZTreeNode> nodes = null;
		ZTreeNode node = null;
		if(list != null){
			nodes = new ArrayList<ZTreeNode>();
			for(SysOrg org : list){
				node = new ZTreeNode();
				node.setId(org.getId());
				node.setName(org.getName());
				node.setpId(org.getParentId());
				node.setOpen(true);
				
				nodes.add(node);
			}
		}
		return nodes;
	}
	
	private void printRequestParams(HttpServletRequest request){
		Map<String,String[]> paramsMap = request.getParameterMap();
		
		if(paramsMap != null && !paramsMap.isEmpty()){
			logger.debug("--------------------request parameters start------------");
			for(Map.Entry<String,String[]> enty: paramsMap.entrySet()){
				logger.debug("{} : {}",enty.getKey(),convertArray(enty.getValue()));
			}
			logger.debug("--------------------request parameters end------------");
		}
		
	}
	
	private String convertArray(String[] strArray){
		if(strArray != null){
			StringBuilder builder = new StringBuilder();
			for(String str : strArray){
				builder.append(str).append(",");
			}
			String returnStr = builder.toString();
			return returnStr.substring(0, returnStr.length()-1);
		}
		return "";
	}
}
