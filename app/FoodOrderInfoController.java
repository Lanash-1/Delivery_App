package app;

import restaurant.FoodItem;

public class FoodOrderInfoController {
	private FoodOrderInfo model;  
	private FoodOrderInfoView view;  
	 
	public FoodOrderInfoController(FoodOrderInfo model, FoodOrderInfoView view) {
		this.model = model;
		this.view = view;
	}
	
	public FoodItem getFoodItem() {
		return model.getFoodItem();
	}
	public void setFoodItem(FoodItem foodItem) {
		model.setFoodItem(foodItem);
	}
	public int getQuantity() {
		return model.getQuantity();
	}
	public void setQuantity(int quantity) {
		model.setQuantity(quantity);
	}
	public String getCustomerName() {
		return model.getCustomerName();
	}
	public void setCustomerName(String customerName) {
		model.setCustomerName(customerName);
	}
	public String getCustomerNumber() {
		return model.getCustomerNumber();
	}
	public void setCustomerNumber(String customerNumber) {
		model.setCustomerNumber(customerNumber);
	}
	public String getCustomerAddress() {
		return model.getCustomerAddress();
	}
	public void setCustomerAddress(String customerAddress) {
		model.setCustomerAddress(customerAddress);
	}
	public boolean isPaid() {
		return model.isPaid();
	}
	public void setPaid(boolean paid) {
		model.setPaid(paid);
	}
	public int getRestaurantId() {
		return model.getRestaurantId();
	}
	public void setRestaurantId(int restaurantId) {
		model.setRestaurantId(restaurantId);
	}
	public String getRestaurantName() {
		return model.getRestaurantName();
	}
	public void setRestaurantName(String restaurantName) {
		model.setRestaurantName(restaurantName);
	}
	public String getRestaurantLocation() {
		return model.getRestaurantLocation();
	}
	public void setRestaurantLocation(String restaurantLocation) {
		model.setRestaurantLocation(restaurantLocation);
	}
	public String getRestaurantMobileNumber() {
		return model.getRestaurantMobileNumber();
	}
	public void setRestaurantMobileNumber(String restaurantMobileNumber) {
		model.setRestaurantMobileNumber(restaurantMobileNumber);
	}
	
	public void viewFoodOrderInfo() {
		view.printFoodOrderDetails(model.getCustomerName(), model.getCustomerAddress(), model.getCustomerNumber(), model.getRestaurantName(), model.getRestaurantLocation(), model.getRestaurantMobileNumber());
	}
}
