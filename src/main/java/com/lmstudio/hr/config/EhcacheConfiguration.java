/**
* TODO
* @Project: hrapp
* @Title: EhcacheConfiguration.java
* @Package com.lmstudio.hr.config
* @author jason
* @Date 2017年2月17日 上午11:15:16
* @Copyright
* @Version 
*/
package com.lmstudio.hr.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

/**
 * TODO
 * 
 * @ClassName: EhcacheConfiguration
 * @author jason
 */
@Configuration
@EnableCaching
public class EhcacheConfiguration {

	@Bean
	public EhCacheCacheManager ehCacheCacheManager(EhCacheManagerFactoryBean factory) {
		return new EhCacheCacheManager(factory.getObject());
	}

	@Bean
	public EhCacheManagerFactoryBean ehCacheManagerFactoryBean() {
		EhCacheManagerFactoryBean ehCacheManagerFactoryBean = new EhCacheManagerFactoryBean();
		ehCacheManagerFactoryBean.setConfigLocation(new ClassPathResource("conf/ehcache.xml"));
		/*
		 * 据shared与否的设置, Spring分别通过CacheManager.create() 或new
		 * CacheManager()方式来创建一个ehcache基地.
		 * 
		 * 也说是说通过这个来设置cache的基地是这里的Spring独用,还是跟别的(如hibernate的Ehcache共享)
		 * 
		 */
		ehCacheManagerFactoryBean.setShared(true);
		return ehCacheManagerFactoryBean;

	}
}
