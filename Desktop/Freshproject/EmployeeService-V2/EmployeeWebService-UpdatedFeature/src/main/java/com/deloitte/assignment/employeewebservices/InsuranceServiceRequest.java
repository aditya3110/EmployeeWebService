package com.deloitte.assignment.employeewebservices;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;



public class InsuranceServiceRequest {

    private int empId;
    
    
    
    

	public InsuranceServiceRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InsuranceServiceRequest(int empId) {
		super();
		this.empId = empId;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}
    
    
	
}
