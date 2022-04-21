package groceryorder;

import customer.Customer;

public class GroceryOrder {
	private Grocery grocery;
	private Customer customer;
	private int quantity;  
	private boolean paid;
	
	public Grocery getGrocery() {
		return grocery;
	}
	public void setGrocery(Grocery grocery) {
		this.grocery = grocery;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
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
	
}
