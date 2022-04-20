package restaurant;
import java.util.ArrayList;

public class RestaurantPartner {
	private int restaurantId;
	private String restaurantName;
	private String restaurantLocation;
	private String restaurantMobileNumber;
	private String restaurantPassword;
	private ArrayList<FoodItem> restaurantMenu;
	
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
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
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
}
