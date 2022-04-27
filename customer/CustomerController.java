package customer;

import java.io.IOException;

import customer.membership.Membership;
import validation.DetailsVerification;
import validation.EmailAndPasswordVerification;
import validation.GenerateOtp;

public class CustomerController extends GenerateOtp implements EmailAndPasswordVerification, DetailsVerification{
	private Customer model;  
	private CustomerView view;  
	 
	public CustomerController(Customer model, CustomerView view) {
		this.model = model;
		this.view = view;
	}
	
	public void setCustomerName(String customerName){
		model.setCustomerName(customerName);		
	}
	
	public String getCustomerName(){
		return model.getCustomerName();		
	}
	
	public void setCustomerPassword(String customerPassword){
		model.setCustomerPassword(customerPassword);		
	}
	
	public String getCustomerPassword(){
		return model.getCustomerPassword();		
	}
	
	public void setCustomerAddress(String customerAddress){
		model.setCustomerAddress(customerAddress);		
	}
	
	public String getCustomerAddress(){
		return model.getCustomerAddress();		
	}
    
	public void setCustomerNumber(String customerNumber){
		model.setCustomerNumber(customerNumber);		
	}
	
	public String getCustomerNumber(){
		return model.getCustomerNumber();		
	}
	
	public boolean isMember() {
		return model.isMember();
	}
	public void setMember(boolean isMember) {
		model.setMember(isMember);
	}
	public Membership getMembership() {
		return model.getMembership();
	}
	public void setMembership(Membership membership) {
		model.setMembership(membership);
	}
	
	public String getCustomerEmail() {
		return model.getCustomerEmail();
	}
	public void setCustomerEmail(String customerEmail) {
		model.setCustomerEmail(customerEmail);
	}
	
	public void updateView(){				
		try {
			view.printCustomerDetails(model.getCustomerName(), model.getCustomerNumber(), model.getCustomerAddress(), model.getMembership(), model.isMember(), model.getCustomerEmail());
		} catch (IOException e) {
			System.out.println("Error in display");
		}
	}

	public boolean validate(String email) {
		if(email.endsWith("@gmail.com") && email.length() > 10) {
			return true;
		}
		System.out.println("Enter valid email id");
		return false;
	}

	public boolean validate(int generatedOtp, int enteredOtp) {
		if(generatedOtp == enteredOtp) {
			System.out.println("Verified");
			return true;
		}
		System.out.println("Entered otp is not matching. Try again");
		return false;
	}

	public boolean validate(String password, String rePassword) {
		if(password.length() < 4){
			view.viewMessage("Password too short. Should atleast 4 characters", "\u001B[31m");
			return false;
		}
		if(password.equals(rePassword)) {
			System.out.println("Password Matching. Continue signup.");
			return true;
		}
		view.viewMessage("Password not matching. Try again", "\u001B[31m");
		return false;
	}
	
	public boolean validate(String name, String mobileNumber, String location) {
		if(location.length() < 1 || mobileNumber.length()!=10 || name.length() < 1) {
			System.out.println("Enter details properly");
			return false;
		}
		return true;
	}
}
