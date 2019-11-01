package com.wzz.demo.integration.service.common;

//import org.antlr.stringtemplate.StringTemplate;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
//import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.BestAvailableRule;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
/**
 * 服务配置类
 * @author wang
 *
 */
@Configuration
public class IntegrationConfig {
	
	/**
	 * 利用 Ribbon 的 loadBalanced实现负载均衡配置类
	 * @return
	 */
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(){
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate;
		
	}
	
//	@Bean
//	public IRule ribbonRule(){
//		return new RoundRobinRule();
//	}
	
	
//	@Bean
//	@ConditionalOnMissingBean(name = "redisTemplate")
//	public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory){
//		RedisTemplate<Object, Object> template = new RedisTemplate<>();
//		template.setConnectionFactory(redisConnectionFactory);
//		return template;
//	}
	
//	@Bean
//	@ConditionalOnMissingBean
//	public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory redisConnectionFactory){
//		StringRedisTemplate template = new StringRedisTemplate(redisConnectionFactory);
//		return template;
//	}
	
	
}
