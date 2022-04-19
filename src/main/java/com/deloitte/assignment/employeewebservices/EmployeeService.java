package com.deloitte.assignment.employeewebservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> getAllUsers(){
		return employeeRepository.findAll();
	}
	
	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public List<Employee> deleteEmployee(int id) {
		 employeeRepository.deleteById(id);
		 return employeeRepository.findAll();
	}
	
	public Employee getOneEmployee(int id) {
		return employeeRepository.getById(id);
	}

}
