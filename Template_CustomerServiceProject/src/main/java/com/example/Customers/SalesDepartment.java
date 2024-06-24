package com.example.Customers;

/*
     This class is an implementation of a CustomerCare Interface based on the selection 
     in the console the department type is selected.You need to complete this class 
     based on the following tasks.

     Tasks:
       1. Override the methods of CustomerCare Interface:
       2. Build your logic for all the method based on the description given in CustomerCare Interface.
 */
public class SalesDepartment implements CustomerCare {

	private String department = "Sales Department";
	private String customerName;
	private String issue;
	private double refId;

	@Override
	public String getDepartment() {
		return department;
	}

	@Override
	public void getService() {
		System.out.println("Welcome "+ customerName +", you have reached the Sales department");

	}

	@Override
	public void setCustomerName(String name) {
		this.customerName =name;

	}

	@Override
	public void setProblem(String problem) {
		this.issue=problem;

	}

	@Override
	public void getProblem() {
		System.out.println(" Dear "+ customerName +"your issue for "+issue+". has been recorded, your reference id is : "+refId);

	}
}
