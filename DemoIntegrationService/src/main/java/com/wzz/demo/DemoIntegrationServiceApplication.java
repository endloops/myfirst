package com.wzz.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
/**
 * 最上层 service 之一 
 * @author wang
 * 开启 hystrix    服务
 * 开启 Eureka 客户端注册
 *
 */
@EnableFeignClients("com.wzz.demo.integration.service.service.feign")
@EnableEurekaClient
@EnableHystrix
@SpringBootApplication
@EnableDistributedTransaction
@EnableTransactionManagement
public class DemoIntegrationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoIntegrationServiceApplication.class, args);
	}

}
