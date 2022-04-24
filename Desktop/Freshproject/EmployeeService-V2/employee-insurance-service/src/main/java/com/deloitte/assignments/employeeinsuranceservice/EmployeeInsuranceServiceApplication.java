package com.deloitte.assignments.employeeinsuranceservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients("com.deloitte.assignment.employeeinsuranceservices")
@EnableDiscoveryClient
@SpringBootApplication
public class EmployeeInsuranceServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeInsuranceServiceApplication.class, args);
	}

}
