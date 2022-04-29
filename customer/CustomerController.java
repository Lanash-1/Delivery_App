package customer;

import java.io.IOException;

import customer.membership.Membership;

public class CustomerController{
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

	public boolean getCustomerInfo() {
		view.getCustomerDetails();
//		view.getCustomerName();
//		view.getPassword();
		model.setCustomerPassword(view.password);
		if(model.verifyPassword(model.getCustomerPassword(), view.repassword)) {
			view.getCustomerInfo();
			model.setCustomerAddress(view.address);
			model.setCustomerName(view.customerName);
			model.setCustomerNumber(view.mobileNumber);
			if(model.verifyCustomerInfo(model.getCustomerName(), model.getCustomerNumber(), model.getCustomerAddress())) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
		
	}
}
