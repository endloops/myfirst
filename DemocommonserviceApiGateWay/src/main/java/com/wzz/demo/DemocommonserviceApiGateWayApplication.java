package com.wzz.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

@SpringBootApplication
@EnableDiscoveryClient
public class DemocommonserviceApiGateWayApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemocommonserviceApiGateWayApplication.class, args);
	}

}
