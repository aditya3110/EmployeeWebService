package com.deloitte.assignments.employeeinsuranceservice.RabbitMQ;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.deloitte.assignments.employeeinsuranceservice.Insurance;
import com.deloitte.assignments.employeeinsuranceservice.InsuranceService;

@Component
public class MessageListener{
	
	@Autowired
	private InsuranceService insurance;
	
	@RabbitListener(queues="Insurance")
	public void listener(InsuranceServiceRequest insuranceRequest) {
		
		insurance.createOne(insuranceRequest.getEmpId());
	}

}