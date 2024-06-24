package com.YaminiBalaji.SocialMedia.SocialMedia;

import com.YaminiBalaji.SocialMedia.SocialMedia.User.Post;
import com.YaminiBalaji.SocialMedia.SocialMedia.User.PostList;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class SocialMediaApplication {

	public static void main(String[] args) {
//		SpringApplication.run(SocialMediaApplication.class, args);
		// get the context from the xml
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//		Post post = (Post) context.getBean("simplePost");


		// prompt the user
		System.out.println("Social media app! start");

		// setup scanner
		Scanner scanner = new Scanner(System.in);

		// infinite loop
		while(true) {
			// fetch a post list;
			PostList postList = (PostList)context.getBean("simplePostList");
			System.out.println("the reference of post list "+postList.toString());


			// prompt user for different options
			System.out.println("1) make new post \n2)show all posts \n3)exit");
			int menuItem = scanner.nextInt();
			switch (menuItem) {
				case 1: {
					Post post = (Post)context.getBean("simplePost");
					System.out.println("please enter a post");
					scanner.nextLine(); // getting the \n and moving to the next input
					String message = scanner.nextLine();
					post.setMessage(message);
					postList.setPost(post);
					break;
				}
				case 2: {
					System.out.println("All the posts !");
					for(int i =0;i<postList.size();i++) {
						System.out.println("the ref of post "+postList.getPost(i).toString());
						System.out.println(i+") " +postList.getPost(i).getMessage());
					}
					break;
				}
				case 3: {
					break;
				}
				default:
					System.out.println("error");
			}
			if(menuItem == 3) {
				break;
			}
		}
		scanner.close();
		context.close();
	}

}


/*
@SpringBootApplication
public class SocialMediaApplication {

	public static void main(String[] args) {
		//SpringApplication.run(SocialMediaApplication.class, args);
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		System.out.println("Welcome to Social Media Application !!!!!!!!!......");



		Scanner sc = new Scanner(System.in);
		while (true){
			System.out.println(" 1. make new post \n 2. get All posts \n 3. Exit");
			int menuItem = sc.nextInt();



			PostList postList = (PostList) context.getBean("simplePostList");
			switch (menuItem) {
				case 1: {
					Post post = (Post)context.getBean("simplePost");
					System.out.println("please enter a post");
					sc.nextLine(); // getting the \n and moving to the next input
					String message = sc.nextLine();
					post.setMessage(message);
					postList.setPost(post);
					break;
				}
				case 2: {
					System.out.println("All the posts !");
					for(int i =0;i<postList.size();i++) {
						System.out.println("the ref of post "+postList.getPost(i).toString());
						System.out.println(i+") " +postList.getPost(i).getMessage());
					}
					break;
				}
				case 3: {
					break;
				}
				default:
					System.out.println("error");
			}

			*/
/*switch (menuitem){
				case 1->{

					Post post = (Post) context.getBean("simplePost");
					System.out.println("Please enter a Post : ");
					sc.nextLine();
					String message = sc.nextLine();
					post.setMessage(message);
					postList.setPost(post);
					System.out.println(" you new post "+post.getMessage()+" have been added ");



				}
				case 2->{
					System.out.println("All the posts !!!");
					for(int i =0; i<postList.size();i++){
						System.out.println(i+" " +postList.getPost(i).getMessage());
					}
					
				}
				case  3->{
					context.close();
					return;
				}
				default -> {
					System.out.println("Please choose a valid option");
					return ;
				}
			}
*//*


		}
	}

}
*/
