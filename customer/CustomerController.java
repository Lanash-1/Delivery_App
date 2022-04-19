package customer;

public class CustomerController {
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
	
	public void updateView(){				
		view.printCustomerDetails(model.getCustomerName(), model.getCustomerNumber(), model.getCustomerAddress(), model.getMembership(), model.isMember());
	}
}
