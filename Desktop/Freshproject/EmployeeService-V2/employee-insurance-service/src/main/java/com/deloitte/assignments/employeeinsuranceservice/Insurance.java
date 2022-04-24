package com.deloitte.assignments.employeeinsuranceservice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Insurance {

    @Id
    @GeneratedValue
	private int insuranceId;
    
    private int employeeId;
    
    private String status;
    
     

	public Insurance() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Insurance(int insuranceId, int employeeId, String insuranceType, String status) {
		super();
		this.insuranceId = insuranceId;
		this.employeeId = employeeId;
	
		this.status = status;
	}



	public int getInsuranceId() {
		return insuranceId;
	}

	public void setInsuranceId(int insuranceId) {
		this.insuranceId = insuranceId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
    
    
	
}
