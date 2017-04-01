/**
* TODO
* @Project: hrapp
* @Title: DataGridVo.java
* @Package com.lmstudio.hr.vo
* @author jason
* @Date 2017年3月13日 上午10:26:03
* @Copyright
* @Version 
*/
package com.lmstudio.hr.web.vo;

import java.util.List;

/**
* TODO
* @ClassName: DataGridVo
* @author jason
*/
public class DataGridVo<T> {

	private int total;
	private List<T> rows;
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	
	
}
