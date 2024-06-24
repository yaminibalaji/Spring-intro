package com.YaminiBalaji.PayMeNow.Payment;

public class BankTransferPaymentService implements  PaymentService{
    @Override
    public void processPayment() {
        System.out.println("BankTransferPaymentService");

    }
}
