package com.kodewala.app.bean;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class Account {
	private String name;
	private String accountType;

	public Account() {

	}
// 1 . constructor 
	public Account(String _name, String _accountType) {

		this.name = _name;
		this.accountType = _accountType;

	}
//	  // 2. Setter Injection
//    public void setName(String name) {
//        System.out.println("2. Setter called");
//        this.name = name;
//    }
	
	

    // 3. PostConstruct
    @PostConstruct
    public void init() {
        System.out.println("3. @PostConstruct called");
    }

    // 4. Business Method
    public void print() {
        System.out.println("4. Bean Ready: " + name + " | " + accountType);
    }

    // 5. PreDestroy
    @PreDestroy
    public void destroy() {
        System.out.println("5. @PreDestroy called");
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

}
