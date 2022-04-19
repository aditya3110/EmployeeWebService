package com.deloitte.assignment.employeewebservices;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeTestDeleteEmployee {
	
	@Autowired
	private EmployeeService service;
	
	@MockBean
	private EmployeeRepository employeeRepository;
	
	@Test
	public void DeleteOneEmployeeTest() {
		
		Employee employee=new Employee(1000,"Aditya","Analyst",50000);
		service.deleteEmployee(1000);
		Assert.assertEquals(0, service.getAllUsers().size());
	}

}
