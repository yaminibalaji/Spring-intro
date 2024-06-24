package com.codingNinjas.Bank.Account.Registration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.Lifecycle;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class BankAccountRegistrationApplication {

    public static void main(String[] args) {

		/*
		You need to complete this application as mentioned in the problem 
		statement build your own logic and perform the following tasks.
		
		* 1. Fetch context from ApplicationContext.xml and initiate scanner.
		* 2. Get user details from console.
		* 3. Get account details from user and add them to the account list.
		* 4. Display the list of accounts with their reference ids.
		*/


         ApplicationContext context = SpringApplication.run(BankAccountRegistrationApplication.class,args);
            Scanner scanner = new Scanner(System.in);

            // Retrieve User bean from context
            User user = (User) context.getBean("myUser");

            // Welcome message and get user name
            System.out.println("Welcome to Account Registration Application");
            System.out.print("Please enter the name: ");
            String name = scanner.nextLine();
            user.setUserDetails(name);

        System.out.println("Do you want to add an account?");
        System.out.println("  1. Yes");
        System.out.println("  2. No");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (choice == 1) {
            // Account creation loop
            while (true) {


                // Account type selection
                System.out.println("Do you want to add an account?");
                System.out.println("  1. Current");
                System.out.println("  2. Savings");
                int accountTypeChoice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                // Create new account based on user input
                Account account = null;
                if (accountTypeChoice == 1) {
                    account = (Account) context.getBean("currentAccount");
                } else if (accountTypeChoice == 2) {
                    account = (Account) context.getBean("savingsAccount");
                }

                // Set opening balance
                System.out.print("Enter the opening amount: ");
                double openingBalance = scanner.nextDouble();
                scanner.nextLine(); // Consume newline
                account.addBalance(openingBalance);

                // Add account to user
                user.addAccount(account);

                // Ask for adding more accounts
                System.out.println("Do you want to add more accounts?");
                System.out.println("  1. Yes");
                System.out.println("  2. No");
                int addMoreChoice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                if (addMoreChoice == 2) {
                    break;
                }
            }

            // Print user's account details
            System.out.println("\nHi " + user.getName() + ", here is the list of your accounts:\n");
            for (Account account : user.getAllAccounts()) {
                System.out.println(account.getAccountType() + ": opening balance " + account.getBalance() +
                        " Reference Id @" + Integer.toHexString(System.identityHashCode(account)));
            }

            // Close scanner
            scanner.close();



        }









    }

}
