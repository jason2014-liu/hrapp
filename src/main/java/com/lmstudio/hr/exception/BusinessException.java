/**
* TODO
* @Project: hrapp
* @Title: BusinessException.java
* @Package com.lmstudio.hr.exception
* @author jason
* @Date 2017年3月7日 上午10:13:11
* @Copyright
* @Version 
*/
package com.lmstudio.hr.exception;

/**
* TODO 业务逻辑异常
* <p>As this class is a runtime exception, there is no need for user code
* to catch it;RuntimeException and its subclasses are unchecked exceptions</p>
* @ClassName: BusinessException
* @author jason
*/
public class BusinessException extends RuntimeException {

	/**
	* serialVersionUID : TODO
	*/
	private static final long serialVersionUID = 1L;

	
	/**
	 * 可以定义错误码，错误信息描述等字段来细化异常信息，看具体业务复杂程度及场景.
	 * 数据库操作因使用了spring 统一封装，故数据库操作异常基类为DataAccessException
	 * 系统集成部分也可设计一个异常，以便处理
	* TODO
	 */

	public BusinessException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public BusinessException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}


	
	

}
