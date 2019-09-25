package com.wzz.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient /* 适用于Eureka,consule,zookeeper */
@SpringBootApplication
public class DemocommonserviceAdminServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemocommonserviceAdminServerApplication.class, args);
	}

}
