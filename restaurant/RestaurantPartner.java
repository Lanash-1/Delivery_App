package restaurant;
import java.util.ArrayList;

import foodorder.FoodOrderInfo;

public class RestaurantPartner {
	private String restaurantEmailId;
	private String restaurantName;
	private String restaurantLocation;
	private String restaurantMobileNumber;
	private String restaurantPassword;
	private ArrayList<FoodItem> restaurantMenu = new ArrayList<FoodItem>();
	private ArrayList<FoodOrderInfo> orders = new ArrayList<FoodOrderInfo>();
	
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public String getRestaurantLocation() {
		return restaurantLocation;
	}
	public void setRestaurantLocation(String restaurantLocation) {
		this.restaurantLocation = restaurantLocation;
	}
	public String getRestaurantMobileNumber() {
		return restaurantMobileNumber;
	}
	public void setRestaurantMobileNumber(String restaurantMobileNumber) {
		this.restaurantMobileNumber = restaurantMobileNumber;
	}
	public ArrayList<FoodItem> getRestaurantMenu() {
		return restaurantMenu;
	}
	public void setRestaurantMenu(ArrayList<FoodItem> restaurantMenu) {
		this.restaurantMenu = restaurantMenu;
	}
	public String getRestaurantPassword() {
		return restaurantPassword;
	}
	public void setRestaurantPassword(String restaurantPassword) {
		this.restaurantPassword = restaurantPassword;
	}
	public String getRestaurantEmailId() {
		return restaurantEmailId;
	}
	public void setRestaurantEmailId(String restaurantEmailId) {
		this.restaurantEmailId = restaurantEmailId;
	}
	public ArrayList<FoodOrderInfo> getOrders() {
		return orders;
	}
	public void setOrders(ArrayList<FoodOrderInfo> orders) {
		this.orders = orders;
	}
}
