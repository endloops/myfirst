package com.wzz.demo.integration.service.common;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper.DefaultTyping;
import com.wzz.demo.integration.service.repository.bean.RedisObjectSerializer;

@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport{
	
	@Autowired
	private RedisConnectionFactory connectionFactory;
	/**
	 *注解@Cacheable 生效
	 */
	@Bean
	public CacheManager cacheManager(){
		 RedisSerializer<String> redisSerializer = new StringRedisSerializer();
		 Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
		 ObjectMapper mapper = new ObjectMapper();
		 mapper.setVisibility(PropertyAccessor.ALL,Visibility.ANY);
		 mapper.enableDefaultTyping(DefaultTyping.NON_FINAL);
		 jackson2JsonRedisSerializer.setObjectMapper(mapper);;
		 RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
	                .entryTtl(Duration.ofHours(1))
	                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(redisSerializer))
	                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(jackson2JsonRedisSerializer))
	                ; 
		 		
		 return RedisCacheManager
				 .builder(RedisCacheWriter.nonLockingRedisCacheWriter(connectionFactory))
				 .cacheDefaults(redisCacheConfiguration)
				 .build();
	}
	/**
	 *使用 redisTemplate 才生效
	 *只用注解@Cacheable  这个配置没用
	 */
	@Bean(name="redisTemplate")
	public RedisTemplate redisTemplate() {
	        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
	        redisTemplate.setConnectionFactory(connectionFactory);
	        // 字符串Key序列化
	        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
	        
	        // 对象值序列化
	        RedisObjectSerializer objectRedisSerializer = new RedisObjectSerializer();
	        redisTemplate.setValueSerializer(objectRedisSerializer);
	        redisTemplate.setHashValueSerializer(objectRedisSerializer);
	        redisTemplate.setKeySerializer(stringRedisSerializer);
	        redisTemplate.setHashKeySerializer(stringRedisSerializer);
	        redisTemplate.afterPropertiesSet();
	        return redisTemplate;
	    }
}
