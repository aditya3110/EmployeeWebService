package com.deloitte.assignment.employeewebservices;

import java.net.URI;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;
import java.util.logging.Logger;


import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class EmployeeController {

@Autowired
private EmployeeRepository employeeRepository;



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
   
	
	Employee savedEmployee = employeeRepository.save(employee);
 
  if(savedEmployee==null)
  throw new Exception("Invalid Entry");
  
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
