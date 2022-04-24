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
public class EmployeeTestGetOneEmployee {
	
	@Autowired
	private EmployeeService service;
	
	@MockBean
	private EmployeeRepository employeeRepository;

	@Test
	public void GetOneEmployeeTest() { //this unit testing is for both creating a new employee and getting an employee 
	    
		
		when(employeeRepository.getById(1)).thenReturn(new Employee(1,"Aditya","Analyst",1000));
		Assert.assertEquals(1,service.getOneEmployee(1).getEmpId());
	}
}
