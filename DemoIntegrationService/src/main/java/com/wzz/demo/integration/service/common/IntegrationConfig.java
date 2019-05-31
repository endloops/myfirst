package com.wzz.demo.integration.service.common;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
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
	
}
