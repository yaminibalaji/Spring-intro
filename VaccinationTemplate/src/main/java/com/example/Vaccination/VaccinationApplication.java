package com.example.Vaccination;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class VaccinationApplication {

    public static void main(String[] args) {

        /*
		You need to complete this application as mentioned in the problem 
		statement build your own logic and perform the following tasks.

		 Tasks:
		1. Fetch context from ApplicationContext.xml and initiate Scanner.
		2. Fetch vaccine and User type choice.
		3. Get the required bean from context.
		4. Get the appointment details form user
		5. Display the appointment details
		6. Run the loop again to book for another user or else exit.
		 */
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Vaccination Application ");
        while (true){
            System.out.println("Please choose your vaccination preference : \n 1. Covid \n 2. Polio \n 3. Typoid \n ");
            int n = sc.nextInt();
            String vaccine ="";
            switch (n){
                case 1-> vaccine ="Covid";
                case 2-> vaccine ="Polio";
                case 3-> vaccine ="Typhoid";
                default ->{
                    return;
                }
            }

            System.out.println("Whom do you want to vaccinated : \n 1. Father \n 2. Mother \n 3. Self \n 4. Spouse \n 5.Exit \n");
            int x = sc.nextInt();
            String vaccinate ="";
            switch (x){
                case 1 ->vaccinate="father";
                case 2->vaccinate="mother";
                case 3-> vaccinate="self";
                case 4->vaccinate="spouse";
                case 5->{
                    context.close();
                    return;
                }
                default -> {
                    System.out.println("Please select a valid option ....");
                    continue;
                }
            }
            User user = (User) context.getBean(vaccinate+vaccine);
                if(user.IsVaccinated()){
                    System.out.println("he is already vaccinated");
                    continue;
                }

                System.out.println("Please enter "+vaccinate+" Details : ");
                sc.nextLine();
                System.out.println("Name : ");

                String name = sc.nextLine();

                System.out.println("Age : ");
                int age = sc.nextInt();
                sc.nextLine();

                System.out.println("Appoiintment date (YYYY-MM-DD) : ");
                String date = sc.nextLine();

                System.out.println("Appoiintment time (HH:MM AM/PM) : ");
                String time = sc.nextLine();

                System.out.println("Appoiintment location : ");
                String location = sc.nextLine();

                TimeAndLocation timeAndLocation = (TimeAndLocation) context.getBean("timeAndLocationBean");
                timeAndLocation.setDetails(time,location,date);
                String timeLocationDate = timeAndLocation.getDetails();
                user.setUserDetails(name,age,timeAndLocation);
                user.setAppointment();


                System.out.println("Do you want to register for someone else  : \n 1. Yes \n 2. No \n  ");
                int y = sc.nextInt();
                if(y==2)
                    break;









        }
        context.close();



    }
}