package com.wzz.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class DemoEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoEurekaApplication.class, args);
	}

}
