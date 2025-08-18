

package com.solidPrinciples.ak;

public class SingleResponsibilityPrinciple {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PaymentConfirmation conf = new PaymentConfirmation();
		PaymentService ps = new PaymentService(conf);

		ps.processPayment(100.00);
	}
}

class PaymentService {
	private PaymentConfirmation conf;

	public PaymentService(PaymentConfirmation conf) {
		this.conf = conf;
	}

	public void processPayment(double amount) {
		System.out.println("Processing payment of $" + amount);
		conf.sendConfirmation(amount);
	}
}

class PaymentConfirmation {
	public void sendConfirmation(double amount) {
		System.out.println("Confirmation: Payment of $" + amount + " completed.");
	}
}
