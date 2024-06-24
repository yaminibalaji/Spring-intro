package com.YaminiBalaji.PayMeNow.Payment;

public class PayPalPaymentService implements  PaymentService{
    @Override
    public void processPayment() {
        System.out.println("PayPalPaymentService");
    }
}
