package groceryorder;

import customer.Customer;

public class GroceryOrderController {
	private GroceryOrder model;
	private GroceryOrderView view;
	
	public GroceryOrderController(GroceryOrder model, GroceryOrderView view) {
		this.model = model;
		this.view = view;
	}
	
	public Grocery getGrocery() {
		return model.getGrocery();
	}
	public void setGrocery(Grocery grocery) {
		model.setGrocery(grocery);
	}
	public Customer getCustomer() {
		return model.getCustomer();
	}
	public void setCustomer(Customer customer) {
		model.setCustomer(customer);
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
	
	public int getTotalBill() {
		return model.getTotalBill();
	}
	public void setTotalBill(int totalBill) {
		model.setTotalBill(totalBill);
	}

	public void viewGroceryOrder() {
		view.printGroceryOrderDetails(model.getGrocery(), model.getCustomer(), model.getQuantity(), model.isPaid());
	}
}
