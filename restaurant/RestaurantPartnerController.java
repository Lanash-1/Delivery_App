package restaurant;

import java.util.ArrayList;

import foodorder.FoodOrderInfo;
import validation.DetailsVerification;
import validation.EmailAndPasswordVerification;
import validation.GenerateOtp;

public class RestaurantPartnerController extends GenerateOtp implements EmailAndPasswordVerification, DetailsVerification{
	private RestaurantPartner model;  
	private RestaurantPartnerView view;  
	 
	public RestaurantPartnerController(RestaurantPartner model, RestaurantPartnerView view) {
		this.model = model;
		this.view = view;
	}
	
	public String getRestaurantName() {
		return model.getRestaurantName();
	}
	public void setRestaurantName(String restaurantName) {
		model.setRestaurantName(restaurantName);
	}
	public String getRestaurantMobileNumber() {
		return model.getRestaurantMobileNumber();
	}
	public void setRestaurantMobileNumber(String restaurantMobileNumber) {
		model.setRestaurantMobileNumber(restaurantMobileNumber);
	}
	public String getRestaurantLocation() {
		return model.getRestaurantLocation();
	}
	public void setRestaurantLocation(String restaurantLocation) {
		model.setRestaurantLocation(restaurantLocation);
	}
	public ArrayList<FoodItem> getRestaurantMenu() {
		return model.getRestaurantMenu();
	}
	public void setRestaurantMenu(ArrayList<FoodItem> restaurantMenu) {
		model.setRestaurantMenu(restaurantMenu);
	}
	
	public String getRestaurantPassword() {
		return model.getRestaurantPassword();
	}
	public void setRestaurantPassword(String restaurantPassword) {
		model.setRestaurantPassword(restaurantPassword);
	}
	
	public String getRestaurantEmailId() {
		return model.getRestaurantEmailId();
	}
	public void setRestaurantEmailId(String restaurantEmailId) {
		model.setRestaurantEmailId(restaurantEmailId);
	}
	public ArrayList<FoodOrderInfo> getOrders() {
		return model.getOrders();
	}
	public void setOrders(ArrayList<FoodOrderInfo> orders) {
		model.setOrders(orders);
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
			System.out.println("Password is too short. Try again");
			return false;
		}
		if(password.equals(rePassword)) {
			System.out.println("Password Matching. Continue signup.");
			return true;
		}
		System.out.println("Password not matching. Try again");
		return false;
	}	
	public boolean validate(String name, String mobileNumber, String location) {
		if(location.length() < 1 || mobileNumber.length()!=10 || name.length() < 1) {
			System.out.println("Enter details properly");
			return false;
		}
		return true;
	}
	public void updateView(){				
		view.printRestaurantPartnerDetails(model.getRestaurantName(), model.getRestaurantMobileNumber(), model.getRestaurantLocation(), model.getRestaurantEmailId());
	}
	
	public void viewMenu() {
		view.printRestaurantMenu(model.getRestaurantMenu());
	}
	
	public void viewOrder() {
		view.printViewOrders(model.getOrders());
	}

}
