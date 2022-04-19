package restaurant;

import java.util.ArrayList;

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
	public int getRestaurantId() {
		return model.getRestaurantId();
	}
	public void setRestaurantId(int restaurantId) {
		model.setRestaurantId(restaurantId);
	}
	public ArrayList<FoodItem> getRestaurantMenu() {
		return model.getRestaurantMenu();
	}
	public void setRestaurantMenu(ArrayList<FoodItem> restaurantMenu) {
		model.setRestaurantMenu(restaurantMenu);
	}
	
	public void updateView(){				
		view.printRestaurantPartnerDetails(model.getRestaurantId(), model.getRestaurantName(), model.getRestaurantMobileNumber(), model.getRestaurantLocation());
	}
	
	public void viewMenu() {
		view.printRestaurantMenu(model.getRestaurantMenu());
	}
}
