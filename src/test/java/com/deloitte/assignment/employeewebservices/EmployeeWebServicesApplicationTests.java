package com.deloitte.assignment.employeewebservices;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class EmployeeWebServicesApplicationTests {

	
	@MockBean
	private EmployeeRepository employeeRepository;

	@Test
	public void retrieveAllEmployeesTest() {
		when(employeeRepository.findAll()).thenReturn(List.of(new Employee(1,"Aditya","Analyst",45000)));
		
		Assert.assertEquals(1, employeeRepository.findAll().size());
	}
	
	@Test
	public void SaveOneEmployeeTest() { //this unit testing is for both creating a new employee and getting an employee 
	
		Employee employee = new Employee(1000,"Aditya","Anayst",50000); 
		when(employeeRepository.save(employee)).thenReturn(employee);
		
		Assert.assertEquals(1000, employee.getEmpId());
	}
	
	@Test
	public void GetOneEmployeeTest() { //this unit testing is for both creating a new employee and getting an employee 
	    
		
		
		employeeRepository.save(new Employee(1,"Aditya","Analyst",10000));
		employeeRepository.save(new Employee(2,"Aditya","Analyst",10000));
		employeeRepository.save(new Employee(3,"Aditya","Analyst",10000));
		Employee employee=new Employee(2,"Aditya","Analyst",10000);
		
		when(employeeRepository.getById(2)).thenReturn(employee);
		Assert.assertEquals(2, employee.getEmpId());
	}
	
}
