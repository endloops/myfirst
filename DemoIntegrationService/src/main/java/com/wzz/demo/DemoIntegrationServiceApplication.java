package com.wzz.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
/**
 * 最上层 service 之一 
 * @author wang
 * 开启 hystrix    服务
 * 开启 Eureka 客户端注册
 *
 */
@EnableEurekaClient
@EnableHystrix
@SpringBootApplication
public class DemoIntegrationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoIntegrationServiceApplication.class, args);
	}

}
