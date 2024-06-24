package com.example.Cinemaxify;

public class Self implements User{

    private String name;
    private int age;
    private String memberName = "self";
    private Long contact;
    private String address;
    private Plan plan;

    public void setPlan(Plan plan) {
        this.plan = plan;
    }
// Add setPlan(Plan plan) method which sets plan attribute:


    @Override
    public void setUserDetails(String name, int age, Long contact, String address) {
        this.name = name;
        this.age = age;
        this.contact = contact;
        this.address = address;
    }

    @Override
    public void getUserDetails() {
        System.out.println("Hello " + name + " you have entered the following details:");
        System.out.println(" age: " +age + "\n contact: " + contact + "\n address: " +address);
        System.out.println("You have selected a "+ plan.getPlanName() + " plan for " + memberName);
    }

    @Override
    public Plan getUserPlan() {
        return this.plan;
    }
}
