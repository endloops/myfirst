package com.wzz.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@EnableAdminServer /*注册admin server*/
@EnableDiscoveryClient /*适用于Eureka,consule,zookeeper*/
@SpringBootApplication
public class DemocommonserviceAdminServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemocommonserviceAdminServerApplication.class, args);
	}

}
