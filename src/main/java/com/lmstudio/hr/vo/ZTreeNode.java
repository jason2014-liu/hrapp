/**
* TODO
* @Project: hrapp
* @Title: ZTreeNode.java
* @Package com.lmstudio.hr.vo
* @author jason
* @Date 2017年3月6日 上午11:25:30
* @Copyright
* @Version 
*/
package com.lmstudio.hr.vo;

/**
* TODO
* @ClassName: ZTreeNode
* @author jason
*/
public class ZTreeNode {

	private String id;
	private String pId;
	private String name;
	
	private String href;//自定义属性
	private boolean open;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public boolean getOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}
	
	
	
	
}
