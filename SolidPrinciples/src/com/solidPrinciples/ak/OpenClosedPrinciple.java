package com.solidPrinciples.ak;

public class OpenClosedPrinciple {

    public static void main(String[] args) {
    	// TODO Auto-generated method stub
        PaymentProcessor pp = new PaymentProcessor();

        PaymentMethod cc = new CreditCardPayment();
        pp.makePayment(cc, 150.00);

        PaymentMethod paypal = new PayPalPayment();
        pp.makePayment(paypal, 250.00);
    }
}

interface PaymentMethod {
    void pay(double amt);
}

class CreditCardPayment implements PaymentMethod {
    @Override
    public void pay(double amt) {
        System.out.println("Paid ₹" + amt + " using Credit Card.");
    }
}

class PayPalPayment implements PaymentMethod {
    @Override
    public void pay(double amt) {
        System.out.println("Paid ₹" + amt + " using PayPal.");
    }
}

class PaymentProcessor {
    public void makePayment(PaymentMethod pm, double amt) {
        pm.pay(amt);
    }
}
