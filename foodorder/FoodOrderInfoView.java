package foodorder;

import customer.Customer;
import restaurant.RestaurantPartner;

public class FoodOrderInfoView {
	public void printFoodOrderDetails(Customer customer, RestaurantPartner restaurant) {
		System.out.println("Pickup Details");
		System.out.println("Restaurant Name: " + restaurant.getRestaurantName());
		System.out.println("Location: " + restaurant.getRestaurantLocation());
		System.out.println("Contact Number: " + restaurant.getRestaurantMobileNumber());
		System.out.println("Delivery Details");
		System.out.println("Customer Name: " + customer.getCustomerName());
		System.out.println("Address: " + customer.getCustomerAddress());
		System.out.println("Contact Number: " + customer.getCustomerNumber());
	}
}