package com.deloitte.assignment.employeewebservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
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




public int getMinSalary() {
	return minSalary;
}


public void setMinSalary(int minSalary) {
	this.minSalary = minSalary;
}


public int getMaxLetter() {
	return maxLetter;
}


public void setMaxLetter(int maxLetter) {
	this.maxLetter = maxLetter;
}


public Validation() {
	super();	
	// TODO Auto-generated constructor stub
}



public Validation(int minSalary, int maxLetter, Employee employee) {
	super();
	this.minSalary = minSalary;
	this.maxLetter = maxLetter;
	this.employee = employee;
}


public void setEmployee(Employee employee) {
	this.employee = employee;
}



public Boolean validateEntry(){
	
	System.out.println(maxLetter);
	if(employee.getEmpName().length() > maxLetter)
		return false;
	
	if(employee.getSalary() < minSalary)
		return false;
	
	return true;
	
}

}
