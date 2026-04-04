package com.kodewala.paym;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Payment {
	@Value("1000")
	private int amount;

	@Value("Id123")
	private String paymentId;

	@Value("PAID")
	private String status;

	public int getAmount() {
		return amount;
	}

	

	public String getPaymentId() {
		return paymentId;
	}


	public String getStatus() {
		return status;
	}

	

}
