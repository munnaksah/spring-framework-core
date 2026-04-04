package com.kodewala.academy;



// pojo -  paine old  java object 
/*
 * "POJO is a simple Java class used to represent data, without any dependency on frameworks, typically 
 * containing fields, getters/setters, and constructors."
 */
public class AccountInfo {

	private String name;
	private String accountType;

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
