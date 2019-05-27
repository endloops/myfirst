package com.wzz.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class DemoIntegrationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoIntegrationServiceApplication.class, args);
	}

}
