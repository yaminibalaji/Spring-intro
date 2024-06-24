package com.YaminiBalaji.PayMeNow.PayMeNow;

import com.YaminiBalaji.PayMeNow.Payment.PaymentService;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class PayMeNowApplication {

	public static void main(String[] args) {
		SpringApplication.run(PayMeNowApplication.class, args);

		ClassPathXmlApplicationContext cc = new ClassPathXmlApplicationContext("ApplicationContext.xml");

		while (true){
			System.out.println("Please choose a number for payment mode : \n 1. BankTransferPaymentService \n 2.CreditCardPaymentService \n 3.PayPalPaymentService \n 0. Exit \n" );
			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			String bean ="";
			switch (n){
				case 1 -> bean = "bankTransferPaymentService";
				case 2 -> bean = "creditCardPaymentService";
				case 3 -> bean = "payPalPaymentService";
				case 0 ->{
					cc.close();
					return;

				}
				default -> {
					System.out.println("Please choose valid option ");
					continue;
				}

			}
			PaymentService ps = (PaymentService) cc.getBean(bean);
			ps.processPayment();

		}
	}

}
