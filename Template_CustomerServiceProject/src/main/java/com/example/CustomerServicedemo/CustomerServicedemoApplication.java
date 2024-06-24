package com.example.CustomerServicedemo;

import com.example.Customers.CustomerCare;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;

@SpringBootApplication
public class CustomerServicedemoApplication {

    private static Scanner sc;

    public static void main(String[] args) {

		/*
		You need to complete this application as mentioned in the problem 
		statement build your own logic and perform the following tasks.

			 Tasks:
		 *  1. Load the beans from ApplicationContext.xml
		 *  2. Display all the departments available and get the input from user.
		 *  3. Get the message from user and store it into the respective department.
		 *  
		 */
       ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        System.out.println("Welcome to our Customer Care application");
        sc = new Scanner(System.in);
        System.out.println("Please enter your name : ");
        String name = sc.next();
        System.out.println("Thanks for reaching us "+name);



        while (true) {
            System.out.println("Please select a department to connect to: \n 1.Payment Department \n 2. Query Department \n 3. Sales Department \n 0. Exit \n ");
            int choice = sc.nextInt();
            sc.nextLine();
            String bean ="";
            switch (choice) {
                case 1:
                    bean = "paymentDepartment";
                    break;
                case 2:
                    bean = "querydepartment";
                    break;
                case 3:
                    bean = "salesDepartment";
                    break;
                case 4:
                    context.close();
                    return;
                default:
                    continue;

            }
            CustomerCare cc = (CustomerCare) context.getBean(bean);
            cc.setCustomerName(name);
            cc.getService();

            String query = sc.nextLine();
            cc.setProblem(query);
            cc.getProblem();


        }




    }
}
