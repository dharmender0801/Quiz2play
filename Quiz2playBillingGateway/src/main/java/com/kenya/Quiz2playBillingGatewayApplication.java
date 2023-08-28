package com.kenya;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Quiz2playBillingGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(Quiz2playBillingGatewayApplication.class, args);
	}

}
