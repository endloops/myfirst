package com.wzz.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;

@SpringBootApplication
@EnableDistributedTransaction
@EnableTransactionManagement
public class DemoGeneralFileA1ServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoGeneralFileA1ServiceApplication.class, args);
	}

}
