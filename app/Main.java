package app;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Membership{
	int price;
	String benefits = "free delivery on all orders";
	String type;
}

interface PaymentMethod{
	void pay(String fromAccount, int amount);
}

class Upi implements PaymentMethod{
	public void pay(String fromAccount, int amount) {
		System.out.println("Successfully paid: Rs" + amount);
		System.out.println("Amount received from upi id: "+ fromAccount);
	}
}

class Card implements PaymentMethod{
	public void pay(String fromAccount, int amount) {
		System.out.println("Successfully paid: Rs" + amount);
		System.out.println("Amount received from card number: "+fromAccount);
	}
}

class CustomerProfile{
	String username;
	String address;
	String mobileNo;
	boolean isMember = false;
	Membership membership;
	
	void showProfile() {
		System.out.println("Username: " + username);
		System.out.println("Mobile number: " + mobileNo);
		System.out.println("Address: " + address);
		if(isMember) {
			System.out.println("Membership: "+ membership.type);
		}else {
			System.out.println("Buy membership to avail free delivery");
		}
	}
}

class Grocery{
	int productId;
	String productName;
	int productPrice;
}

class GroceryOrder{
	Grocery grocery;
	int quantity;
	String customerName;
	String customerNumber;
	String address;
}

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// declaration and initialization
		int choice;
		Map<String, String> customerLoginDetails= new HashMap<String, String>();
		String customerUserName = "";
		String customerPassword, confirm;
		CustomerProfile profile;
		Map<String, CustomerProfile> customerProfile = new HashMap<String, CustomerProfile>();
		ArrayList<Grocery> groceryList = new ArrayList<Grocery>();
		
		Grocery item1 = new Grocery();
		item1.productName = "Milk";
		item1.productPrice = 30;
		item1.productId = 1;
		groceryList.add(item1);
		Grocery item2 = new Grocery();
		item2.productName = "Chips";
		item2.productPrice = 10;
		item2.productId = 2;
		groceryList.add(item2);
		Grocery item3 = new Grocery();
		item3.productName = "Wheat";
		item3.productPrice = 200;
		item3.productId = 3;
		groceryList.add(item3);
		
		ArrayList<GroceryOrder> groceryOrderList = new ArrayList<>();
		GroceryOrder grocery;
		// end of block
		while(true) {		
			System.out.println("1. Cutomer\n2. Delivery Partner\n3. Restaurant partner\n4. Close app");
			choice = sc.nextInt();
			switch(choice) {
			case 1: // customer
				System.out.println("1. Login\n2. Signup");
				choice = sc.nextInt();
				sc.nextLine();
				switch(choice) {
				case 1: // Customer login
					System.out.print("Enter username: ");
					customerUserName = sc.nextLine();
					System.out.print("Enter password: ");
					customerPassword = sc.nextLine();
					if(customerLoginDetails.containsKey(customerUserName)) {
						if(customerLoginDetails.get(customerUserName).equals(customerPassword)) {
							System.out.println("Welcome back");
						}else {
							System.out.println("1. Forgot password\n2. exit");
							choice = sc.nextInt();
							switch(choice) {
							case 1: // forgot password
								System.out.println("Change Password\nUsername: "+customerUserName);
								System.out.print("Enter new password: ");
								customerPassword = sc.nextLine();
								System.out.print("Confirm new password: ");
								confirm = sc.nextLine();
								if(customerPassword == confirm) {
									customerLoginDetails.put(customerUserName, customerPassword);
									System.out.println("Password changed successfully");
								}else {
									System.out.println("Password not matching Try again.");
									return;
								}
								break;
							case 2: // Exit
								System.out.println("Exit");
								return;
							}
						}
					}else {
						System.out.println("invalid username. Try again");
						return;
					}
					break;
				case 2: // Customer signup
					System.out.print("Enter username: ");
					customerUserName = sc.nextLine();
					profile = new CustomerProfile();
					profile.username = customerUserName;
//					customerProfile.put(customerUserName, profile);
					System.out.print("Enter password: ");
					customerPassword = sc.nextLine();
					customerLoginDetails.put(customerUserName, customerPassword);
					System.out.print("Enter address: ");
					profile.address = sc.nextLine();
					System.out.print("Enter mobile number: ");
					profile.mobileNo = sc.nextLine();
					customerProfile.put(customerUserName, profile);
					System.out.println("Signed up");
					break;
				default:
					System.out.println("Exit");
				}
				
				//---------- end of customer login or signup ---------------
				boolean logout = false;
				while(!logout) {
					System.out.println("1. Order food\n2. Order groceries\n3. Buy membership\n4. View profile\n5. Logout");
					choice = sc.nextInt();
					switch(choice) {
					case 1: // order food section
						break;
					case 2: // order groceries section
						for(Grocery item : groceryList) {
							System.out.println(item.productId+": "+item.productName+", Rs "+item.productPrice);
						}
						System.out.println("Select product");
						int selectedProduct = sc.nextInt();
						System.out.print("Enter quantity: ");
						int productQuantity = sc.nextInt();
						grocery = new GroceryOrder();
						grocery.grocery = groceryList.get(selectedProduct);
						grocery.quantity = productQuantity;
						grocery.address = customerProfile.get(customerUserName).address;
						grocery.customerName = customerProfile.get(customerUserName).username;
						grocery.customerNumber = customerProfile.get(customerUserName).mobileNo;
						groceryOrderList.add(grocery);
						break;
					case 3:
						if(customerProfile.get(customerUserName).isMember) {
							System.out.println("Already a member");
							break;
						}
						System.out.println("1. PRO Membership");
						System.out.println("2. GOLD Membership");
						choice = sc.nextInt();
						Membership membership = new Membership();
						switch(choice) {
						case 1:
							membership.price = 100;
							membership.type = "pro";
							break;
						case 2:
							membership.price = 900;
							membership.type = "gold";
							break;
						default:
							System.out.println("Select only available options");
						}
						System.out.println("Cost: " + membership.price +"\nBenefits: " + membership.benefits);
						System.out.println("1. Pay and Buy\n2. Cancel");
						choice = sc.nextInt();
						switch(choice) {
						case 1:
							System.out.println("1. Pay using card\n2. Pay using upi");
							choice = sc.nextInt();
							sc.nextLine();
							PaymentMethod method;
							switch(choice) {
							case 1:
								System.out.print("Enter card number: ");
								String cardNumber = sc.nextLine();
								method = new Card();
								method.pay(cardNumber, membership.price);
								customerProfile.get(customerUserName).membership = membership;
								customerProfile.get(customerUserName).isMember = true;
								break;
							case 2:
								System.out.print("Enter UPI Id: ");
								String UpiId = sc.nextLine();
								method = new Card();
								method.pay(UpiId, membership.price);
								customerProfile.get(customerUserName).membership = membership;
								customerProfile.get(customerUserName).isMember = true;
								break;
							default:
								System.out.println("Select valid payment option");
							}
							break;
						case 2:
							System.out.println("Canceled");
							break;
						default:
							System.out.println("Option not available");
						}
						break;
					case 4:
						customerProfile.get(customerUserName).showProfile();
						break;
					case 5:
						logout = true;
						break;
					default:
						System.out.println("Select from the available options");
					}
				}
				break;
			case 2: // delivery partner
				
				break;
			case 3: // restaurant partner
				break;
			case 4:
				System.out.println("Closing APP");
				return;
			default:
				System.out.println("Exit");
			}
		}
	}
}
