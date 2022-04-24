package com.deloitte.assignment.employeewebservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients("com.deloitte.assignment.employeewebservices")
public class EmployeeWebServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeWebServicesApplication.class, args);
	}

}
