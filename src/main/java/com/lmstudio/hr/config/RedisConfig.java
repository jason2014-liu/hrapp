/**
* TODO
* @Project: hrapp
* @Title: RedisConfig.java
* @Package com.lmstudio.hr.config
* @author jason
* @Date 2017年2月23日 上午10:41:59
* @Copyright
* @Version 
*/
package com.lmstudio.hr.config;

import java.lang.reflect.Method;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * TODO
 * 
 * @ClassName: RedisConfig
 * @author jason
 */
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {

	@Bean
	public KeyGenerator jasonKeyGenerator() {
		return new KeyGenerator() {

			@Override
			public Object generate(Object target, Method method, Object... params) {
				// TODO Auto-generated method stub
				StringBuilder builder = new StringBuilder();
				builder.append(target.getClass().getName());
				builder.append(method.getName());
				for (Object obj : params) {
					builder.append(obj.toString());
				}
				return builder.toString();
			}
		};
	}

	@Bean
	@SuppressWarnings("rawtypes")
	public RedisTemplate redisTemplate(RedisConnectionFactory connectionFactory) {
		StringRedisTemplate template = new StringRedisTemplate(connectionFactory);
		Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
		ObjectMapper om = new ObjectMapper();
		om.setVisibility(PropertyAccessor.ALL, com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY);
		om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
		jackson2JsonRedisSerializer.setObjectMapper(om);
		template.setValueSerializer(jackson2JsonRedisSerializer);
		template.afterPropertiesSet();
		return template;
	}

	@Bean
	@Primary
	@SuppressWarnings("rawtypes")
	public CacheManager cacheManager(RedisTemplate redisTemplate) {
		return new RedisCacheManager(redisTemplate);
	}
}
