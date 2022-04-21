package groceryorder;

import customer.Customer;

public class GroceryOrderView {
	public void printGroceryOrderDetails(Grocery grocery, Customer customer, int quantity, boolean paid) {
		System.out.println("Pickup Details");
		System.out.println("Product ID: " + grocery.productId);
		System.out.println("Grocery name: " + grocery.productName);
		System.out.println("Grocery price: " + grocery.productPrice);
		System.out.println("Quantity: " + quantity);
		
		System.out.println("Delivery Details");
		System.out.println("Customer Name: " + customer.getCustomerName());
		System.out.println("Address: " + customer.getCustomerAddress());
		System.out.println("Contact Number: " + customer.getCustomerNumber());
	}
}
