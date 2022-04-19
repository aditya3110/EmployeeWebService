package com.deloitte.assignment.employeewebservices;



import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeTestCreateEmployee {
	
	@Autowired
	private EmployeeService service;
	
	@MockBean
	private EmployeeRepository employeeRepository;

	@Test
	public void SaveOneEmployeeTest() { //this unit testing is for both creating a new employee and getting an employee 
	
		Employee employee = new Employee(1000,"Aditya","Anayst",50000); 
		when(employeeRepository.save(employee)).thenReturn(employee);
		
		Assert.assertEquals(employee, service.addEmployee(employee));
	}
}
