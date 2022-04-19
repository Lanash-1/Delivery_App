package app;
public class FoodOrderInfoView {
	public void printFoodOrderDetails(String customerName, String customerAddress, String customerNumber, String restaurantName, String restaurantLocation, String restaurantMobileNumber) {
		System.out.println("Pickup Details");
		System.out.println("Restaurant Name: " + restaurantName);
		System.out.println("Location: " + restaurantLocation);
		System.out.println("Contact Number: " + restaurantMobileNumber);
		System.out.println("Delivery Details");
		System.out.println("Customer Name: " + customerName);
		System.out.println("Address: " + customerAddress);
		System.out.println("Contact Number: " + customerNumber);
	}
}