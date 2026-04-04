package com.kodewala.config;
/*
 * Key Differences
Feature-	@Component     	         @Bean

Level-	    Class-level       	   Method-level
Creation-	  Automatic	         Manual
Control-	  Less control	    Full control
Used for-	  Own classes	        Third-party / custom
Needs @Configuration -❌ No   	 ✅ Yes
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import com.kodewala.bean.Address;
import com.kodewala.bean.Employee;

@Configuration
//@ComponentScan(basePackages = "com.kodewala.bean")
public class SpringConfig {

	@Bean
	public Address createAddress() {

		return new Address("6th cross", "virat nagar, bommnahalli", "bangalore");
	}

	@Bean
	public Employee createEmployee() {

		return new Employee("mannu", "B1", createAddress());
	}
}