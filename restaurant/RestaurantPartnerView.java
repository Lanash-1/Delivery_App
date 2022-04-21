package restaurant;

import java.util.ArrayList;

public class RestaurantPartnerView {
	public void printRestaurantPartnerDetails(String restaurantName, String restaurantMobileNumber, String restaurantLocation, String restaurantEmailId) {
		System.out.println("Restaurant EmailID: " + restaurantEmailId);
		System.out.println("Restaurant Name: " + restaurantName);
		System.out.println("Contact Number: " + restaurantMobileNumber);
		System.out.println("Location: " + restaurantLocation);
	}
	
	public void printRestaurantMenu(ArrayList<FoodItem> restaurantMenu) {
		for(int i=1; i<=restaurantMenu.size(); i++) {
			System.out.println(i+". "+restaurantMenu.get(i-1).foodName+" - "+restaurantMenu.get(i-1).foodCost);
		}
	}
}