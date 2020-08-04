package com.example.User_Server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
@EnableFeignClients("com.example.User_Server")
@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
public class UserApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
		Logger logger = LoggerFactory.getLogger(FallBackHystrix.class);
		logger.info("Welcome To UserApplication!!!");
	}

}
