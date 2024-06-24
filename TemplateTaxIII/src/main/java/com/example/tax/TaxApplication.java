package com.example.tax;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class TaxApplication {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to the Tax Payment Application");
		while (true) {
			System.out.println("Please select which tax you want to pay: \n1. Income \n2. Property\n3. Exit");
			int userChoice = scanner.nextInt();
			String taxChoice = "";
			switch (userChoice) {
				case 1 -> taxChoice = "incomeTax";
				case 2 -> taxChoice = "propertyTax";
				case 3 -> {
					System.out.println("Exiting...");
					return;
				}
				default -> {
					System.out.println("Invalid choice");
					return;
				}
			}
			Tax tax = (Tax) context.getBean(taxChoice);
			/*
			1. Check if the tax is already paid, if yes print the message:
			    "You have already paid Income/Property(get this getTaxType() interface method) tax."
			2. If the tax is not paid:
				a. Take the input of taxableAmount from the user.
				b. Set the taxableAmount using setTaxableAmount() interface method.
				c. Calculate the taxAmount using calculateTaxAmount() interface method.
				d. Ask user if he wants to pay the tax. if yes call the payTax() method.
			 */

			if (tax.isTaxPayed()) {
				System.out.println("You have already paid " + tax.getTaxType() + " tax.");
				continue;
			}

			System.out.println("Please enter the taxable amount:");
			double taxableAmount = scanner.nextDouble();
			tax.setTaxableAmount((int)taxableAmount);

			tax.calculateTaxAmount();
			System.out.println("The tax amount to be paid is: " + tax.getTaxAmount());

			System.out.println("Do you want to pay the tax now? (yes/no)");
			String payChoice = scanner.next();

			if (payChoice.equalsIgnoreCase("yes")) {
				tax.payTax();
			} else {
				System.out.println("Tax payment cancelled.");
			}

		}

	}
}

