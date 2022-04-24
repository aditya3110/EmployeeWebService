package com.deloitte.assignment.employeewebservices;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name="insurance-service" , url="localhost:8081")
 
 public interface EmployeeInsuranceProxy {
	@GetMapping("/employees/insurance/create/{id}")
	public void createInsurance(@PathVariable int id);

}
