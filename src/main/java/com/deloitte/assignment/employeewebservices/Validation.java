package com.deloitte.assignment.employeewebservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.deloitte.assignment.employeewebservices.Employee;

@Service
public class Validation{

@Value("${employee.minSalary}")
private int minSalary;

@Value("${employee.maxLetter}")
private int maxLetter;

private Employee employee;


public Validation() {
	super();	
	// TODO Auto-generated constructor stub
}


public void setEmployee(Employee employee) {
	this.employee = employee;
}



public Boolean validateEntry(){
	
	if(employee.getEmpName().length() > maxLetter && employee.getSalary() < minSalary)
		return false;
	
	return true;
	
}

}
