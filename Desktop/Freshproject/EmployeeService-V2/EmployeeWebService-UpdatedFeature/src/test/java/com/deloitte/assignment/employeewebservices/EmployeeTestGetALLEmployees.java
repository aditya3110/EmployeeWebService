package com.deloitte.assignment.employeewebservices;

import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeTestGetALLEmployees {
	
	@Autowired
	private EmployeeService service;
	
	@MockBean
	private EmployeeRepository employeeRepository;
	@Test
	public void retrieveAllEmployeesTest() {
		when(employeeRepository.findAll()).thenReturn(List.of(new Employee(1,"Aditya","Analyst",45000)));
		
		Assert.assertEquals(1, service.getAllUsers().size());
	}

}
