//package app;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Scanner;
//
////class Membership{
////	int price;
////	String benefits = "free delivery on all orders";
////	String type;
////}
////
////interface PaymentMethod{
////	void pay(String fromAccount, int amount);
////}
////
////class Upi implements PaymentMethod{
////	public void pay(String fromAccount, int amount) {
////		System.out.println("Successfully paid: Rs" + amount);
////		System.out.println("Amount received from upi id: "+ fromAccount);
////	}
////}
////
////class Card implements PaymentMethod{
////	public void pay(String fromAccount, int amount) {
////		System.out.println("Successfully paid: Rs" + amount);
////		System.out.println("Amount received from card number: "+fromAccount);
////	}
////}
////
////class Withdraw{
////	void withdraw(int amount, String accountNumber) {
////		System.out.println("Transaction success.");
////		System.out.println("From: Company\nTo: "+accountNumber);
////	}
////}
//
////class CustomerProfile{
////	String username;
////	String address;
////	String mobileNo;
////	boolean isMember = false;
////	Membership membership;
////	
////	void showProfile() {
////		System.out.println("Username: " + username);
////		System.out.println("Mobile number: " + mobileNo);
////		System.out.println("Address: " + address);
////		if(isMember) {
////			System.out.println("Membership: "+ membership.type);
////		}else {
////			System.out.println("Buy membership to avail free delivery");
////		}
////	}
////}
////
////class PartnerProfile{
////	String name;
////	String mobileNo;
////	String vehicleNo;
////	String partnerId;
////	int earnings = 0;
////	
////	void showProfile() {
////		System.out.println("Partner ID: "+partnerId);
////		System.out.println("Name: " + name);
////		System.out.println("Mobile number: " + mobileNo);
////		System.out.println("Vehicle Number: " + vehicleNo);
////		System.out.println("Earning: " + earnings);
////	}
////}
//
//class Grocery{
//	int productId;
//	String productName;
//	int productPrice;
//}
//
//class GroceryOrder{
//	Grocery grocery;
//	int quantity;
//	String customerName;
//	String customerNumber;
//	String address;
//	boolean paid;
//}
//
//class ViewGroceryOrder{
//	void displayOrder(GroceryOrder groceryOrder) {
//		GroceryOrder order = groceryOrder;
//			System.out.println(order.grocery.productId+": "+order.grocery.productName+", Rs "+order.grocery.productPrice);
//			System.out.println("Quantity: "+order.quantity);
//			System.out.println("Customer Name: "+order.customerName);
//			System.out.println("Customer Number: "+order.customerNumber);
//			System.out.println("Delivery location: "+order.address);
//	}
//}
//
////class Food{
////	String foodName;
////	int foodId;
////	int foodCost;
////}
//
////class Restaurant{
////	String restaurantName;
////	String restaurantLocation;
////	int restaurantId;
////	String restaurantPassword;
////	ArrayList<Food> menu;
////}
//
////class FoodOrder{
////	Food food;
////	int quantity;
////	String customerName;
////	String CustomerNumber;
////	String customerAddress;
////	boolean paid;
////	int restaurantId;
////	String restaurantName;
////	String restaurantLocation;
////}
//
//public class Main {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		// declaration and initialization
//		
//		ArrayList<FoodOrder> orderedFood = new ArrayList<FoodOrder>();
//		ArrayList<FoodOrder> foodToDeliver = new ArrayList<FoodOrder>();
//		FoodOrder foodOrder;
//		Food foodSelected;
//		int restaurantId;
//		String restaurantPassword;
//		Map<Integer, Restaurant> restaurantDetails = new HashMap<Integer, Restaurant>();
//		ArrayList<Food> localMenu = new ArrayList<Food>();
//		Food food1 = new Food();
//		food1.foodId = 1;
//		food1.foodName = "Dosa";
//		food1.foodCost = 20;
//		localMenu.add(food1);
//		Food food2 = new Food();
//		food2.foodId = 2;
//		food2.foodName = "Poori";
//		food2.foodCost = 30;
//		localMenu.add(food2);
//		Food food3 = new Food();
//		food3.foodId = 3;
//		food3.foodName = "Fried Rice";
//		food3.foodCost = 100;
//		localMenu.add(food3);
//		
//		Restaurant restaurant1 = new Restaurant();
//		restaurant1.menu = localMenu;
//		restaurant1.restaurantId = 1;
//		restaurant1.restaurantLocation = "chennai";
//		restaurant1.restaurantName = "A2B";
//		restaurant1.restaurantPassword = "123";
//		restaurantDetails.put(1, restaurant1);
//		Restaurant restaurant2 = new Restaurant();
//		restaurant2.menu = localMenu;
//		restaurant2.restaurantId = 2;
//		restaurant2.restaurantLocation = "chennai";
//		restaurant2.restaurantName = "saravana bhavan";
//		restaurant2.restaurantPassword = "123";
//		restaurantDetails.put(2, restaurant2);
//		Restaurant restaurant3 = new Restaurant();
//		restaurant3.menu = localMenu;
//		restaurant3.restaurantId = 3;
//		restaurant3.restaurantLocation = "chennai";
//		restaurant3.restaurantName = "Kfc";
//		restaurant3.restaurantPassword = "123";
//		restaurantDetails.put(3, restaurant3);
//		
//		int choice;
//		Map<String, String> customerLoginDetails= new HashMap<String, String>();
//		String customerUserName = "";
//		String customerPassword, confirm;
//		CustomerProfile profile;
//		Map<String, CustomerProfile> customerProfile = new HashMap<String, CustomerProfile>();
//		ArrayList<Grocery> groceryList = new ArrayList<Grocery>();
//		
//		Grocery item1 = new Grocery();
//		item1.productName = "Milk";
//		item1.productPrice = 30;
//		item1.productId = 1;
//		groceryList.add(item1);
//		Grocery item2 = new Grocery();
//		item2.productName = "Chips";
//		item2.productPrice = 10;
//		item2.productId = 2;
//		groceryList.add(item2);
//		Grocery item3 = new Grocery();
//		item3.productName = "Wheat";
//		item3.productPrice = 200;
//		item3.productId = 3;
//		groceryList.add(item3);
//		
//		ArrayList<GroceryOrder> groceryOrderList = new ArrayList<>();
//		GroceryOrder grocery;
//		
//		String partnerId, partnerPassword;
//		Map<String, String> partnerLoginDetails= new HashMap<String, String>();
//		PartnerProfile partner;
//		Map<String, PartnerProfile> partnerProfile = new HashMap<String, PartnerProfile>();
//		
//		// end of block
//		while(true) {		
//			System.out.println("1. Cutomer\n2. Delivery Partner\n3. Restaurant partner\n4. Close app");
//			choice = sc.nextInt();
//			switch(choice) {
//			case 1: // customer
//				System.out.println("1. Login\n2. Signup");
//				choice = sc.nextInt();
//				sc.nextLine();
//				switch(choice) {
//				case 1: // Customer login
//					System.out.print("Enter username: ");
//					customerUserName = sc.nextLine();
//					System.out.print("Enter password: ");
//					customerPassword = sc.nextLine();
//					if(customerLoginDetails.containsKey(customerUserName)) {
//						if(customerLoginDetails.get(customerUserName).equals(customerPassword)) {
//							System.out.println("Welcome back");
//						}else {
//							System.out.println("1. Forgot password\n2. exit");
//							choice = sc.nextInt();
//							switch(choice) {
//							case 1: // forgot password
//								System.out.println("Change Password\nUsername: "+customerUserName);
//								System.out.print("Enter new password: ");
//								customerPassword = sc.nextLine();
//								System.out.print("Confirm new password: ");
//								confirm = sc.nextLine();
//								if(customerPassword == confirm) {
//									customerLoginDetails.put(customerUserName, customerPassword);
//									System.out.println("Password changed successfully");
//								}else {
//									System.out.println("Password not matching Try again.");
//									return;
//								}
//								break;
//							case 2: // Exit
//								System.out.println("Exit");
//								return;
//							}
//						}
//					}else {
//						System.out.println("invalid username. Try again");
//						return;
//					}
//					break;
//				case 2: // Customer signup
//					System.out.print("Enter username: ");
//					customerUserName = sc.nextLine();
//					profile = new CustomerProfile();
//					profile.username = customerUserName;
////					customerProfile.put(customerUserName, profile);
//					System.out.print("Enter password: ");
//					customerPassword = sc.nextLine();
//					customerLoginDetails.put(customerUserName, customerPassword);
//					System.out.print("Enter address: ");
//					profile.address = sc.nextLine();
//					System.out.print("Enter mobile number: ");
//					profile.mobileNo = sc.nextLine();
//					customerProfile.put(customerUserName, profile);
//					System.out.println("Signed up");
//					break;
//				default:
//					System.out.println("Exit");
//					return;
//				}
//				
//				//---------- end of customer login or signup ---------------
//				boolean logout = false;
//				while(!logout) {
//					System.out.println("1. Order food\n2. Order groceries\n3. Buy membership\n4. View profile\n5. Logout");
//					choice = sc.nextInt();
//					switch(choice) {
//					case 1: // order food section
//						System.out.println("Select restaurant");
//						for(int i=1; i<=3; i++) {
//							System.out.println(i+" "+restaurantDetails.get(i).restaurantName);
//						}
//						int selectedRestaurant = sc.nextInt();
//						if(restaurantDetails.containsKey(selectedRestaurant)) {
//							for(Food food : restaurantDetails.get(selectedRestaurant).menu) {
//								System.out.println(food.foodId+". "+food.foodName+" - Rs."+food.foodCost);
//							}
//							int selectedFood = sc.nextInt();
//							if(selectedFood <= restaurantDetails.get(selectedRestaurant).menu.size() && selectedFood >0) {
//								foodSelected = restaurantDetails.get(selectedRestaurant).menu.get(selectedFood-1);
//								System.out.print("Enter Quantity: ");
//								int foodQuantity = sc.nextInt();
//								System.out.println("1. Pay now\n2. Cash on delivery");
//								choice = sc.nextInt();
//								switch(choice) {
//								case 1:
//									System.out.println("1. Card\n2. Upi");
//									choice = sc.nextInt();
//									sc.nextLine();
//									PaymentMethod method;
//									switch(choice) {
//									case 1:
//										System.out.print("Enter card number: ");
//										String cardNumber = sc.nextLine();
//										method = new Card();
//										method.pay(cardNumber, foodSelected.foodCost * foodQuantity);
//										break;
//									case 2:
//										System.out.print("Enter UPI Id: ");
//										String UpiId = sc.nextLine();
//										method = new Card();
//										method.pay(UpiId, foodSelected.foodCost * foodQuantity);
//										break;
//									default:
//										System.out.println("Select valid payment option");
//									}
//									foodOrder = new FoodOrder();
//									foodOrder.food = foodSelected;
//									foodOrder.quantity = foodQuantity;
//									foodOrder.customerAddress = customerProfile.get(customerUserName).address;
//									foodOrder.customerName = customerProfile.get(customerUserName).username;
//									foodOrder.CustomerNumber = customerProfile.get(customerUserName).mobileNo;
//									foodOrder.paid = true;
//									foodOrder.restaurantName = restaurantDetails.get(selectedRestaurant).restaurantName;
//									foodOrder.restaurantLocation = restaurantDetails.get(selectedRestaurant).restaurantLocation;
//									foodOrder.restaurantId = restaurantDetails.get(selectedRestaurant).restaurantId;
//									orderedFood.add(foodOrder);
//									break;
//								case 2:
//									foodOrder = new FoodOrder();
//									foodOrder.food = foodSelected;
//									foodOrder.quantity = foodQuantity;
//									foodOrder.customerAddress = customerProfile.get(customerUserName).address;
//									foodOrder.customerName = customerProfile.get(customerUserName).username;
//									foodOrder.CustomerNumber = customerProfile.get(customerUserName).mobileNo;
//									foodOrder.paid = false;
//									foodOrder.restaurantName = restaurantDetails.get(selectedRestaurant).restaurantName;
//									foodOrder.restaurantLocation = restaurantDetails.get(selectedRestaurant).restaurantLocation;
//									foodOrder.restaurantId = restaurantDetails.get(selectedRestaurant).restaurantId;
//									orderedFood.add(foodOrder);
//									break;
//								default:
//									System.out.println("Select any payment option");
//								}
//								break;
//							}else {
//								System.out.println("Select only available food");
//								break;
//							}
//						}else {
//							System.out.println("Option not available");
//							break;
//						}
//					case 2: // order groceries section
//						for(Grocery item : groceryList) {
//							System.out.println(item.productId+": "+item.productName+", Rs "+item.productPrice);
//						}
//						System.out.println("Select product");
//						int selectedProduct = sc.nextInt();
//						if(selectedProduct > groceryList.size() || selectedProduct < 1) {
//							System.out.println("Select only available items");
//							break;
//						}
//						System.out.print("Enter quantity: ");
//						int productQuantity = sc.nextInt();
//						System.out.println("1. Pay now\n2. Cash on delivery");
//						choice = sc.nextInt();
//						switch(choice) {
//						case 1:
//							System.out.println("1. Card\n2. Upi");
//							choice = sc.nextInt();
//							sc.nextLine();
//							PaymentMethod method;
//							switch(choice) {
//							case 1:
//								System.out.print("Enter card number: ");
//								String cardNumber = sc.nextLine();
//								method = new Card();
//								method.pay(cardNumber, groceryList.get(selectedProduct-1).productPrice * productQuantity);
//								break;
//							case 2:
//								System.out.print("Enter UPI Id: ");
//								String UpiId = sc.nextLine();
//								method = new Card();
//								method.pay(UpiId, groceryList.get(selectedProduct-1).productPrice * productQuantity);
//								break;
//							default:
//								System.out.println("Select valid payment option");
//							}
//							grocery = new GroceryOrder();
//							grocery.grocery = groceryList.get(selectedProduct-1);
//							grocery.quantity = productQuantity;
//							grocery.address = customerProfile.get(customerUserName).address;
//							grocery.customerName = customerProfile.get(customerUserName).username;
//							grocery.customerNumber = customerProfile.get(customerUserName).mobileNo;
//							grocery.paid = true;
//							groceryOrderList.add(grocery);
//							break;
//						case 2:
//							grocery = new GroceryOrder();
//							grocery.grocery = groceryList.get(selectedProduct-1);
//							grocery.quantity = productQuantity;
//							grocery.address = customerProfile.get(customerUserName).address;
//							grocery.customerName = customerProfile.get(customerUserName).username;
//							grocery.customerNumber = customerProfile.get(customerUserName).mobileNo;
//							grocery.paid = false;
//							groceryOrderList.add(grocery);
//							break;
//						default:
//							System.out.println("Select any payment option");
//						}
//						break;
//					case 3:
//						if(customerProfile.get(customerUserName).isMember) {
//							System.out.println("Already a member");
//							break;
//						}
//						System.out.println("1. PRO Membership");
//						System.out.println("2. GOLD Membership");
//						choice = sc.nextInt();
//						Membership membership = new Membership();
//						switch(choice) {
//						case 1:
//							membership.price = 100;
//							membership.type = "pro";
//							break;
//						case 2:
//							membership.price = 900;
//							membership.type = "gold";
//							break;
//						default:
//							System.out.println("Select only available options");
//						}
//						System.out.println("Cost: " + membership.price +"\nBenefits: " + membership.benefits);
//						System.out.println("1. Pay and Buy\n2. Cancel");
//						choice = sc.nextInt();
//						switch(choice) {
//						case 1:
//							System.out.println("1. Pay using card\n2. Pay using upi");
//							choice = sc.nextInt();
//							sc.nextLine();
//							PaymentMethod method;
//							switch(choice) {
//							case 1:
//								System.out.print("Enter card number: ");
//								String cardNumber = sc.nextLine();
//								method = new Card();
//								method.pay(cardNumber, membership.price);
//								customerProfile.get(customerUserName).membership = membership;
//								customerProfile.get(customerUserName).isMember = true;
//								break;
//							case 2:
//								System.out.print("Enter UPI Id: ");
//								String UpiId = sc.nextLine();
//								method = new Upi();
//								method.pay(UpiId, membership.price);
//								customerProfile.get(customerUserName).membership = membership;
//								customerProfile.get(customerUserName).isMember = true;
//								break;
//							default:
//								System.out.println("Select valid payment option");
//							}
//							break;
//						case 2:
//							System.out.println("Canceled");
//							break;
//						default:
//							System.out.println("Option not available");
//						}
//						break;
//					case 4:
//						customerProfile.get(customerUserName).showProfile();
//						break;
//					case 5:
//						logout = true;
//						break;
//					default:
//						System.out.println("Select from the available options");
//					}
//				}
//				break;
//			case 2: // delivery partner
//				System.out.println("1. Login\n2. Register");
//				choice = sc.nextInt();
//				sc.nextLine();
//				switch(choice) {
//				case 1: // Delivery partner login
//					System.out.print("Enter Partner ID: ");
//					partnerId = sc.nextLine();
//					System.out.print("Enter password: ");
//					partnerPassword = sc.nextLine();
//					if(partnerLoginDetails.containsKey(partnerId)) {
//						if(partnerLoginDetails.get(partnerId).equals(partnerPassword)) {
//							System.out.println("Welcome back");
//						}else {
//							System.out.println("1. Forgot password\n2. exit");
//							choice = sc.nextInt();
//							switch(choice) {
//							case 1: // forgot password
//								System.out.println("Change Password\nPartner ID: "+partnerId);
//								System.out.print("Enter new password: ");
//								partnerPassword = sc.nextLine();
//								System.out.print("Confirm new password: ");
//								confirm = sc.nextLine();
//								if(partnerPassword == confirm) {
//									partnerLoginDetails.put(partnerId, partnerPassword);
//									System.out.println("Password changed successfully");
//								}else {
//									System.out.println("Password not matching Try again.");
//									return;
//								}
//								break;
//							case 2: // Exit
//								System.out.println("Exit");
//								return;
//							}
//						}
//					}else {
//						System.out.println("invalid partner ID. Try again");
//						return;
//					}
//					break;
//				case 2: // Delivery partner signup
//					partner = new PartnerProfile();
//					System.out.print("Enter FullName: ");
//					String partnerName = sc.nextLine();
//					partner.name = partnerName;
//					System.out.print("Enter password: ");
//					partnerPassword = sc.nextLine();
//					System.out.print("Create partner Id: ");
//					partnerId = sc.nextLine();
//					partner.partnerId = partnerId;
//					partnerLoginDetails.put(partnerId, partnerPassword);
//					System.out.print("Enter Vehicle Number: ");
//					partner.vehicleNo = sc.nextLine();
//					System.out.print("Enter mobile number: ");
//					partner.mobileNo = sc.nextLine();
//					partnerProfile.put(partnerId, partner);
//					System.out.println("Signed up");
//					break;
//				default:
//					System.out.println("Exit");
//					return;
//				}
//				boolean partnerLogout = false;
//				while(!partnerLogout) {
//					System.out.println("1.View Food order\n2. View Grocery Order\n3. View Profile\n4. Withdraw Earnings\n5. logout");
//					choice = sc.nextInt();
//					switch(choice) {
//					case 1: // view food order
//						if(foodToDeliver.size() < 1) {
//							System.out.println("Currently no orders");
//							break;
//						}
//						System.out.println(foodToDeliver.get(0).restaurantName+" - "+foodToDeliver.get(0).restaurantLocation);
//						System.out.println("1. Accept order\n2. skip order");
//						choice = sc.nextInt();
//						switch(choice) {
//						case 1: // accept food order
//							System.out.println("Order accepted");
//							System.out.println("-Picked up order");
//							System.out.println("- -Delivered to customer");
//							if(!foodToDeliver.get(0).paid) {
//								System.out.println("- - -Amount collected");
//							}else {
//								System.out.println("- - -Amount paid online");
//							}
//							partnerProfile.get(partnerId).earnings += (foodToDeliver.get(0).quantity * foodToDeliver.get(0).food.foodCost);
//							foodToDeliver.remove(0);
//							break;
//						case 2: // skip order
//							System.out.println("Order skipped");
//							break;
//						default:
//							System.out.println("Either accept or skip");
//						}
//						break;
//					case 2: // view grocery order
//						ViewGroceryOrder viewOrders = new ViewGroceryOrder();
//						viewOrders.displayOrder(groceryOrderList.get(0));
//						System.out.println("1. Accept order\n2. skip order");
//						choice = sc.nextInt();
//						switch(choice) {
//						case 1: // accept order
//							System.out.println("Order accepted");
//							System.out.println("-Picked up order");
//							System.out.println("- -Delivered");
//							if(!groceryOrderList.get(0).paid) {
//								System.out.println("- - -Amount collected");
//							}else {
//								System.out.println("- - -Amount paid online");
//							}
//							partnerProfile.get(partnerId).earnings += (groceryOrderList.get(0).quantity * groceryOrderList.get(0).grocery.productPrice);
//							groceryOrderList.remove(0);
//							break;
//						case 2: // skip order
//							System.out.println("Order skipped");
//							break;
//						default:
//							System.out.println("Either accept or skip");
//						}
//						break;
//					case 3: // view partner profile
//						partnerProfile.get(partnerId).showProfile();
//						break;
//					case 4: // withdraw earnings
//						System.out.print("Enter amount to withdraw: ");
//						int amount = sc.nextInt();
//						sc.nextLine();
//						if(amount <= partnerProfile.get(partnerId).earnings) {
//							System.out.print("Enter account number: ");
//							String accountNumber = sc.nextLine();
//							Withdraw withdraw = new Withdraw();
//							withdraw.withdraw(amount, accountNumber);
//							PartnerProfile dpprofile = partnerProfile.get(partnerId);
//							dpprofile.earnings = dpprofile.earnings - amount;
//							partnerProfile.put(partnerId, dpprofile);
//						}else {
//							System.out.println("Requested amount is more than available balance");
//						}
//						break;
//					case 5:
//						partnerLogout = true;
//						System.out.println("Logged out.");
//						break;
//					default:
//						System.out.println("Select only available features");
//					}
//				}
//				break;
//			case 3: // restaurant
//				boolean logged = false;
//				System.out.println("Login");
//				System.out.print("Enter restaurant Id: ");
//				restaurantId = sc.nextInt();
//				if(restaurantDetails.containsKey(restaurantId)) {
//					sc.nextLine();
//					System.out.print("Enter Password: ");
//					restaurantPassword = sc.nextLine();
//					if(restaurantDetails.get(restaurantId).restaurantPassword.equals(restaurantPassword)) {
//						System.out.println("Welcome. Orders waiting for you.");
//						logged = true;
//						
//					}else {
//						System.out.println("Invalid password. contact our team to change password");
//					}
//				}else {
//					System.out.println("Not a partner. Send us a mail to join as a partner");
//					break;
//				}
//				while(logged) {
//					System.out.println("1. view order\n2. 2. Logout");
//					choice = sc.nextInt();
//					switch(choice) {
//					case 1:
//						if(orderedFood.size() < 1) {
//							System.out.println("No orders");
//							break;
//						}
//						int index = 0;
//						boolean available = false;
//						for(FoodOrder food : orderedFood) {
//							if(food.restaurantId == restaurantId) {
//								index = orderedFood.indexOf(food);
//								available = true;
//								break;
//							}
//						}
//						if(available) {
//							System.out.println(orderedFood.get(index).food.foodName+" - "+orderedFood.get(index).quantity);
//							System.out.println("-Preparing food");
//							System.out.println("- -Food ready to collect");
//							foodToDeliver.add(orderedFood.get(index));
//							orderedFood.remove(index);
//						}else {
//							System.out.println("No orders");
//						}
//						break;
//					case 2:
//						System.out.println("Logged out");
//						logged = false;
//						break;
//					default:
//						System.out.println("invalid option");
//					}
//				}
//				break;
//			case 4:
//				System.out.println("APP closed");
//				return;
//			default:
//				System.out.println("Exit");
//				return;
//			}
//		}
//	}
//}