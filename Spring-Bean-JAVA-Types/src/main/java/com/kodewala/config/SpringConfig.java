package com.kodewala.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kodewala.academy.AccountInfo;

@Configuration   // class level annotation or this is define bean
public class SpringConfig {
	/*
	 * @Bean is used to explicitly define and register a bean in the Spring container ,
	 *  using a method inside a configuration class.
	 */
	@Bean("acc")
	public AccountInfo createAccount() {
		
		AccountInfo accountInfo  =  new AccountInfo();
		accountInfo.setAccountType("Current");
		accountInfo.setName("Kodewala");
		
		return accountInfo;
		
		
	}

}
