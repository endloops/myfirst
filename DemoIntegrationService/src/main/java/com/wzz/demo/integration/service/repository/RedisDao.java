package com.wzz.demo.integration.service.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Repository;

import com.wzz.demo.integration.service.repository.bean.RedisObjectSerializer;

@Repository
public class RedisDao {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Autowired
	private RedisTemplate<Object, Object> redisTemplate;

	public String setKey(String key, String value) {
		ValueOperations<String, String> re = stringRedisTemplate.opsForValue();
		re.set(key, value);
		return value;
	}

	public String getValue(String key) {
		ValueOperations<String, String> res = stringRedisTemplate.opsForValue();
		String value = res.get(key);
		return value;
	}

	@SuppressWarnings("unchecked")
	public <T> T setKey(Object key, Object value,Class<T> valueClasee) {
		redisTemplate.setKeySerializer(new RedisObjectSerializer());
		redisTemplate.setValueSerializer(new RedisObjectSerializer());
		ValueOperations<Object, Object> re = redisTemplate.opsForValue();
		re.set(key, value);
		return (T) value;
	}

	@SuppressWarnings("unchecked")
	public <T> T getValue(Object key, Class<T> res) {
		redisTemplate.setKeySerializer(new RedisObjectSerializer());
		redisTemplate.setValueSerializer(new RedisObjectSerializer());
		ValueOperations<Object, Object> re = redisTemplate.opsForValue();
		Object value = re.get(key);
		return (T) value; 
	}
	@SuppressWarnings("unchecked")
	public <T> T setKey(String key, Object value,Class<T> valueClasee) {
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setValueSerializer(new RedisObjectSerializer());
		ValueOperations<Object, Object> re = redisTemplate.opsForValue();
		re.set(key, value);
		return (T) value;
	}

	@SuppressWarnings("unchecked")
	public <T> T getValue(String key, Class<T> res) {
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setValueSerializer(new RedisObjectSerializer());
		ValueOperations<Object, Object> re = redisTemplate.opsForValue();
		Object value = re.get(key);
		return (T) value; 
	}


}
