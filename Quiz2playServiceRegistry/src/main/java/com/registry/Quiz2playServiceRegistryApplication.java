package com.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Quiz2playServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(Quiz2playServiceRegistryApplication.class, args);
	}

}
