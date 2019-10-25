package com.wzz.demo;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

import com.wzz.demo.integration.service.repository.bean.RedisObjectSerializer;
import com.wzz.demo.integration.service.repository.bean.UserRedisDao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoIntegrationServiceApplicationTests {

	@Autowired
	private RedisTemplate<Object, Object> redisTemplate;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testRedis() throws Exception{
		UserRedisDao redisDao = new UserRedisDao("wang", 1);
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setValueSerializer(new RedisObjectSerializer());
//		redisTemplate.opsForValue().set(redisDao.getUsername(), redisDao);
		System.out.println(redisTemplate.opsForValue().get(redisDao.getUsername()));
		System.out.println("222222222");
	}
	public static void main(String[] args) {
		ArrayList arrayList = new ArrayList<>();
		arrayList.add(1);
		arrayList.add(new Integer(1));
		System.out.println(Arrays.toString(arrayList.toArray()));
	}
}
