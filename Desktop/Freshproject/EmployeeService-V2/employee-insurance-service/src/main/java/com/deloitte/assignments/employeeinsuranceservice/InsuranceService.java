package com.deloitte.assignments.employeeinsuranceservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsuranceService {
	
    @Autowired
	private InsuranceJpaRepository repository;
	
	public void createOne(int id) {
		Insurance insurance=new Insurance();
		insurance.setEmployeeId(id);
		insurance.setStatus("inactive");
	    repository.save(insurance);
	}

}
