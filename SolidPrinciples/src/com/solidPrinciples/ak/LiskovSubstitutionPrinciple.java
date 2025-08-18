
package com.solidPrinciples.ak;

public class LiskovSubstitutionPrinciple {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PaymentMethodLSP m1 = new UPIPayment();
		PaymentMethodLSP m2 = new BankTransfer();

		makePayment(m1, 500.00);
		makePayment(m2, 1000.00);
	}

	public static void makePayment(PaymentMethodLSP method, double amt) {
		method.pay(amt);
	}
}

abstract class PaymentMethodLSP {
	abstract void pay(double amt);
}

class UPIPayment extends PaymentMethodLSP {
	@Override
	public void pay(double amt) {
		System.out.println("Paid ₹" + amt + " using UPI.");
	}
}

class BankTransfer extends PaymentMethodLSP {
	@Override
	public void pay(double amt) {
		System.out.println("Paid ₹" + amt + " using Bank Transfer.");
	}
}
