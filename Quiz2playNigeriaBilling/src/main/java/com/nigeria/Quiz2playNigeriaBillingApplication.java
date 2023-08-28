package com.nigeria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Quiz2playNigeriaBillingApplication {

	public static void main(String[] args) {
		SpringApplication.run(Quiz2playNigeriaBillingApplication.class, args);
	}

}
