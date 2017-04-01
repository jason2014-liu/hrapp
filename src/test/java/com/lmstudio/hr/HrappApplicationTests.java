package com.lmstudio.hr;

import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HrappApplicationTests {
	
	@Autowired
	private RedisTemplate<String, String> redisTemplate;

//	@Test
//	public void contextLoads() {
//	}
	
	@Test
	public void redisTest(){
		
		redisTemplate.opsForSet().add("key1", "value1");
		redisTemplate.opsForSet().add("key1", "value2");
		redisTemplate.opsForSet().add("key1", "value1");
		redisTemplate.opsForSet().add("key2", "value11");
		
		Set<String> keys = redisTemplate.keys("key*");
		if(keys != null){
			for(String key:keys){
				System.out.println("key:"+key);
				Set<String> values = redisTemplate.opsForSet().members(key);
				if(values != null){
					for(String value:values){
						System.out.println("value:"+value);
					}
				}
			}
		}
	}

}
