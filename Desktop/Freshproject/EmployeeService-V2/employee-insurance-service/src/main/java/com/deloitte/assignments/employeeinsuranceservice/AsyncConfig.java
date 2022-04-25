package com.deloitte.assignments.employeeinsuranceservice;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@EnableAsync
@Configuration
public class AsyncConfig {
 
	@Bean(name="InsuranceAsyncExecutor")
	public Executor taskExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(5); // set the core pool size
		executor.setMaxPoolSize(10); // max pool size
		executor.setThreadNamePrefix("Insurance-async"); // give an optional name to your threads
		executor.initialize();
		return executor;
	}
  
}  