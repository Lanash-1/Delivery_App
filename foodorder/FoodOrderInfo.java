package foodorder;
import customer.Customer;
import restaurant.FoodItem;
import restaurant.RestaurantPartner;

public class FoodOrderInfo {
	private FoodItem foodItem;
	private int quantity;
	private boolean paid;
	private Customer customer;
	private RestaurantPartner restaurant;
	private int totalBill;
	
	public FoodItem getFoodItem() {
		return foodItem;
	}
	public void setFoodItem(FoodItem foodItem) {
		this.foodItem = foodItem;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public boolean isPaid() {
		return paid;
	}
	public void setPaid(boolean paid) {
		this.paid = paid;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public RestaurantPartner getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(RestaurantPartner restaurant) {
		this.restaurant = restaurant;
	}
	public int getTotalBill() {
		return totalBill;
	}
	public void setTotalBill(int totalBill) {
		this.totalBill = totalBill;
	}
} 