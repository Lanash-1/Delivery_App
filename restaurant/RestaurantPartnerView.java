package restaurant;

import java.util.ArrayList;

public class RestaurantPartnerView {
	public void printRestaurantPartnerDetails(int restaurantId, String restaurantName, String restaurantMobileNumber, String restaurantLocation) {
		System.out.println("Restaurant ID: " + restaurantId);
		System.out.println("Restaurant Name: " + restaurantName);
		System.out.println("Contact Number: " + restaurantMobileNumber);
		System.out.println("Location: " + restaurantLocation);
	}
	
	public void printRestaurantMenu(ArrayList<FoodItem> restaurantMenu) {
		for(FoodItem food : restaurantMenu) {
			System.out.println(food.foodId+". "+food.foodName+" - "+food.foodCost);
		}
	}
}