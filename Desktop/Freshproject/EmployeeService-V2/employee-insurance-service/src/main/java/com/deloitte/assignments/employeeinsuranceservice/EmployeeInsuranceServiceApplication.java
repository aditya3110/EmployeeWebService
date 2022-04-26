package com.deloitte.assignments.employeeinsuranceservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

@EnableFeignClients("com.deloitte.assignment.employeeinsuranceservices")
@EnableDiscoveryClient
@SpringBootApplication
public class EmployeeInsuranceServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeInsuranceServiceApplication.class, args);
	}
	
	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}

}
