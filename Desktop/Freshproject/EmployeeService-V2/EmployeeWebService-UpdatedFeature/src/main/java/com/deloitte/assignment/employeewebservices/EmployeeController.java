package com.deloitte.assignment.employeewebservices;

import java.io.Console;
import java.net.URI;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;
import java.util.logging.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;



import com.deloitte.assignment.employeewebservices.Validation;

import com.deloitte.assignment.employeewebservices.rabbitMQ.MessagingConfig;

@RestController
public class EmployeeController {
	


@Autowired
private EmployeeRepository employeeRepository;


@Autowired
private RabbitTemplate template;

@Autowired
private Validation validate;

@Autowired
private EmployeeService employeeService;


@GetMapping("/employees")
public List<Employee> retrieveAllEmployees(){


return employeeRepository.findAll();
}

@GetMapping("/employees/{id}")
public EntityModel<Optional<Employee>> getOne(@PathVariable int id) throws Exception{

 Optional<Employee> employee = employeeRepository.findById(id);
 
 if(!employee.isPresent())
 throw new Exception("User Not Found");
 
 EntityModel<Optional<Employee>> model=EntityModel.of(employee);
 return model;

}


@PostMapping("/employees")
public  ResponseEntity<Object> createEmployee(@RequestBody Employee employee) throws Exception{
   
	validate.setEmployee(employee);
	
  Boolean isValid=validate.validateEntry();
  
  if(isValid==false)
	  throw new Exception("Invalid Entry");
		
	
	Employee savedEmployee = employeeService.addEmployee(employee);
   
	
  if(savedEmployee==null)
    throw new Exception("Invalid Entry");
  
 
    template.convertAndSend(MessagingConfig.exchangeName, MessagingConfig.keyName,new InsuranceServiceRequest(savedEmployee.getEmpId()));

  
   URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedEmployee.getEmpId())
  .toUri();
                 
  return ResponseEntity.created(location).build();
}
 
 
@DeleteMapping("/remove-employee/{id}")
public List<Employee> removeEmployee (@PathVariable int id) throws Exception{
	Optional<Employee> employee = employeeRepository.findById(id);
	
	if(!employee.isPresent())
	throw new Exception("User Not Found");
	
	employeeRepository.deleteById(id);
	
	return employeeRepository.findAll();
	
}





}
