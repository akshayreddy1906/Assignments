package com.solidPrinciples.ak;

public class InterfaceSegregationPrinciple {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Payable card = new CreditCardISP();
		card.pay(300.00);

		Payable upi = new UPIPaymentISP();
		upi.pay(150.00);

		Refundable cardRefund = new CreditCardISP();
		cardRefund.refund(100.00);
	}
}

interface Payable {
	void pay(double amt);
}

interface Refundable {
	void refund(double amt);
}
class CreditCardISP implements Payable, Refundable {
	public void pay(double amt) {
		System.out.println("Paid ₹" + amt + " using Credit Card.");
	}

	public void refund(double amt) {
		System.out.println("Refunded ₹" + amt + " to Credit Card.");
	}
}

class UPIPaymentISP implements Payable {
	public void pay(double amt) {
		System.out.println("Paid ₹" + amt + " using UPI.");
	}
}
