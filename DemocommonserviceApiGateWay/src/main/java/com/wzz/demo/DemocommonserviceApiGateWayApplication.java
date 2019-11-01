package com.wzz.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

import com.wzz.demo.config.apigateway.AddAuthoritionHeaderFilter;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class DemocommonserviceApiGateWayApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemocommonserviceApiGateWayApplication.class, args);
	}

	@Bean
	public AddAuthoritionHeaderFilter addAuthoritionHeaderFilter(){
		AddAuthoritionHeaderFilter addAuthoritionHeaderFilter  = new AddAuthoritionHeaderFilter();
		return addAuthoritionHeaderFilter;
	}
}
