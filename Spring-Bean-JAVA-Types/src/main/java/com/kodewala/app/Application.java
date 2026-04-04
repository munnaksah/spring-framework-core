package com.kodewala.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kodewala.academy.AccountInfo;
import com.kodewala.config.SpringConfig;

public class Application {
	public static void main(String[] args) {
		
		// IOC CONTAINER

		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		AccountInfo accountInfo = (AccountInfo) context.getBean("acc");

		System.out.println("details " + accountInfo.getName() + " and " + accountInfo.getAccountType());

	}

}
