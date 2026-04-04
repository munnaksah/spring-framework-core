
package com.kodewala;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kodewala.config.SpringConfig;
import com.kodewala.paym.Payment;

public class App {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

		Payment pay = context.getBean(Payment.class);

		System.out.println(" amoutn:" + pay.getAmount() + " paymentId: " + pay.getPaymentId() + " paymetStatus: "
				+ pay.getStatus());

	}

}
