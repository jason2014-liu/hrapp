/**
* TODO
* @Project: hrapp
* @Title: GlobalExceptionHandler.java
* @Package com.lmstudio.hr.exception
* @author jason
* @Date 2017年3月7日 下午2:15:06
* @Copyright
* @Version 
*/
package com.lmstudio.hr.exception;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.BasicErrorController;
import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

/**
* TODO 全局异常处理类
* @ClassName: GlobalExceptionHandler
* @author jason
*/
@Controller //不可缺失
public class GlobalExceptionController extends BasicErrorController{

	 private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionController.class);
	
	 @Autowired
	public GlobalExceptionController(ServerProperties serverProperties) {
        super(new DefaultErrorAttributes(), serverProperties.getError());
    }

	@Override
	public ModelAndView errorHtml(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpStatus status = getStatus(request);
		Map<String, Object> model = Collections.unmodifiableMap(getErrorAttributes(
				request, isIncludeStackTrace(request, MediaType.TEXT_HTML)));
		response.setStatus(status.value());
		//指定自定义的视图
        return new ModelAndView("error", model);
	}

	@Override
	public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Map<String, Object> body = getErrorAttributes(request,
				isIncludeStackTrace(request, MediaType.ALL));
		HttpStatus status = getStatus(request);
		logger.error(body.toString());

        //输出自定义的Json格式
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", status.value());
        map.put("msg", body.get("message"));

        return new ResponseEntity<Map<String, Object>>(map, status);
        
       // return new ResponseEntity<Map<String, Object>>(body, status);
	}
	
	



}
