package com.solidPrinciples.ak;

public class DependencyInversionPrinciple {

	public static void main(String[] args) {
		PaymentMethodDIP m = new Phonepe();
		PaymentServiceDIP s = new PaymentServiceDIP(m);
		s.makePayment(700.00);
	}
}

interface PaymentMethodDIP {
	void pay(double amt);
}

class PaymentServiceDIP {
	private PaymentMethodDIP m;

	public PaymentServiceDIP(PaymentMethodDIP m) {
		this.m = m;
	}

	public void makePayment(double amt) {
		System.out.println("Starting transaction...");
		m.pay(amt);
		System.out.println("Transaction complete.");
	}
}

class Phonepe implements PaymentMethodDIP {
	public void pay(double amt) {
		System.out.println("Paid ₹" + amt + " via Phonepe.");
	}
}

class DebitCardDIP implements PaymentMethodDIP {
	public void pay(double amt) {
		System.out.println("Paid ₹" + amt + " using Debit Card.");
	}
}
