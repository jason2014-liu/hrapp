/**
* TODO
* @Project: hrapp
* @Title: DruidConfiguration.java
* @Package com.lmstudio.hr.servlet
* @author jason
* @Date 2017年2月13日 下午3:02:43
* @Copyright
* @Version 
*/
package com.lmstudio.hr.servlet;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.lmstudio.hr.config.DruidProperties;

/**
* TODO
* @ClassName: DruidConfiguration
* @author jason
*/
@Configuration
public class DruidConfiguration {
	
	@Autowired
	private DruidProperties properties;
	
	@Bean
	@Primary
	public DataSource dataSource(){
		DruidDataSource dataSource = new DruidDataSource();
		
		dataSource.setUrl(properties.getUrl());
		dataSource.setUsername(properties.getUsername());
		dataSource.setPassword(properties.getPassword());
		
		dataSource.setInitialSize(properties.getInitialSize());;
		dataSource.setMinIdle(properties.getMinIdle());
		dataSource.setMaxActive(properties.getMaxActive());
		dataSource.setMaxWait(properties.getMaxWait());
		
		dataSource.setTimeBetweenEvictionRunsMillis(properties.getTimeBetweenEvictionRunsMillis());
		dataSource.setMinEvictableIdleTimeMillis(properties.getMinEvictableIdleTimeMillis());
		dataSource.setValidationQuery(properties.getValidationQuery());
		dataSource.setTestWhileIdle(properties.isTestWhileIdle());
		dataSource.setTestOnBorrow(properties.isTestOnBorrow());
		dataSource.setTestOnReturn(properties.isTestOnReturn());
		
		dataSource.setPoolPreparedStatements(properties.isPoolPreparedStatements());
		dataSource.setMaxPoolPreparedStatementPerConnectionSize(properties.getMaxPoolPreparedStatementPerConnectionSize());
		try {
			dataSource.setFilters(properties.getFilters());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dataSource.setConnectionProperties(properties.getConnectionProperties());
		return dataSource;
	}

	/**
  	* 注册一个StatViewServlet
     * @return
     */
    @Bean
    public ServletRegistrationBean DruidStatViewServle(){
       //org.springframework.boot.context.embedded.ServletRegistrationBean提供类的进行注册.
       ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
       
       //添加初始化参数：initParams
       
       //白名单：
       servletRegistrationBean.addInitParameter("allow","127.0.0.1");
       //IP黑名单 (存在共同时，deny优先于allow) : 如果满足deny的话提示:Sorry, you are not permitted to view this page.
       //servletRegistrationBean.addInitParameter("deny","192.168.1.73");
       //登录查看信息的账号密码.
       servletRegistrationBean.addInitParameter("loginUsername","admin");
       servletRegistrationBean.addInitParameter("loginPassword","123456");
       //是否能够重置数据.
       servletRegistrationBean.addInitParameter("resetEnable","false");
       return servletRegistrationBean;
    }

	/**
     * 注册一个：filterRegistrationBean
     * @return
     */
    @Bean
    public FilterRegistrationBean druidStatFilter(){
       
       FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
       
       //添加过滤规则.
       filterRegistrationBean.addUrlPatterns("/*");
       
       //添加需要忽略的格式信息.
		filterRegistrationBean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
       return filterRegistrationBean;
    }
	
}
