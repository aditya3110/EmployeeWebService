package com.deloitte.assignments.employeeinsuranceservice;

import java.net.URI;
import java.util.List;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class InsuranceController {
	
	@Autowired
	private InsuranceJpaRepository repository;
	
	@Autowired
	private InsuranceService insuranceService;
	

	
	@GetMapping("/employees/{id}/insurance")
	public Insurance getInsurance(@PathVariable int id) throws Exception {
		
		Insurance insurance=repository.findByemployeeId(id);
		if(insurance==null)
			throw new Exception("No Employee Found");
		
		return repository.findByemployeeId(id);
	}
	
	
	@GetMapping("/employees/getall")
	public List<Insurance> getAll(){
		return repository.findAll();
	}
	
	@Async("InsuranceAsyncExecutor")
	@GetMapping("/employees/insurance/create/{id}")
	public void createInsurance(@PathVariable int id) throws Exception {
		
	
		System.out.println(Thread.currentThread().getName());
	    insuranceService.createOne(id);
	    	
}
	
	@PutMapping("/employees/insurance/update/{id}")
	public String updateInsurance(@PathVariable int id) throws Exception {
		
		Insurance insurance = repository.findByemployeeId(id);
		
		if(insurance==null)
		throw new Exception("No Employee Found");
		
		System.out.println(repository.findByemployeeId(id).getStatus());
		
		if(insurance.getStatus()=="inactive")
			repository.findByemployeeId(id).setStatus("active");
		
		else
			repository.findByemployeeId(id).setStatus("inactive");
		
		
		
		System.out.println(repository.findByemployeeId(id).getStatus());
		repository.save(repository.findByemployeeId(id));
		
		return "STATUS UPDATED!";
	}
	
}
