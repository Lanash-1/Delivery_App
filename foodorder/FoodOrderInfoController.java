package foodorder;

import customer.Customer;
import restaurant.FoodItem;
import restaurant.RestaurantPartner;

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

	public boolean isPaid() {
		return model.isPaid();
	}
	public void setPaid(boolean paid) {
		model.setPaid(paid);
	}

	public Customer getCustomer() {
		return model.getCustomer();
	}
	public void setCustomer(Customer customer) {
		model.setCustomer(customer);
	}
	
	public RestaurantPartner getRestaurant() {
		return model.getRestaurant();
	}
	public void setRestaurant(RestaurantPartner restaurant) {
		model.setRestaurant(restaurant);
	}
	
	public int getTotalBill() {
		return model.getTotalBill();
	}
	public void setTotalBill(int totalBill) {
		model.setTotalBill(totalBill);
	}
	
	public void viewFoodOrderInfo() {
		view.printFoodOrderDetails(model.getCustomer(),model.getRestaurant());
	}
}
