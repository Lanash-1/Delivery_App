package restaurant;

import java.util.ArrayList;

import foodorder.FoodOrderInfo;

public class RestaurantPartnerController {
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
