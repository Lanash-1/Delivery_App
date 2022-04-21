package app;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import customer.Customer;
import customer.CustomerController;
import customer.CustomerView;
import customer.membership.GoldMembership;
import customer.membership.Membership;
import customer.membership.ProMembership;
import customer.membership.Subscription;
import deliverypartner.DeliveryPartner;
import deliverypartner.DeliveryPartnerController;
import deliverypartner.DeliveryPartnerView;
import payment.Card;
import payment.PaymentMethod;
import payment.Upi;
import payment.WithdrawEarnings;
import restaurant.FoodItem;
import restaurant.RestaurantPartner;
import restaurant.RestaurantPartnerController;
import restaurant.RestaurantPartnerView;
import validation.GenerateOtp;
import validation.Validation;

public class App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Validation validate = new Validation();
		GenerateOtp otp = new GenerateOtp();
		HashMap<String, Customer> customerDetails = new HashMap<String, Customer>();
		Customer customerModel;
		CustomerView customerView;
		CustomerController customerController = null;
		HashMap<String, DeliveryPartner> deliveryPartnerDetails = new HashMap<String, DeliveryPartner>();
		DeliveryPartner deliveryModel;
		DeliveryPartnerView deliveryView;
		DeliveryPartnerController deliveryController = null;
		HashMap<String, RestaurantPartner> restaurantDetails = new HashMap<String, RestaurantPartner>();
		RestaurantPartner restaurantModel;
		RestaurantPartnerView restaurantView;
		RestaurantPartnerController restaurantController = null;
		boolean open = true;
		int choice;
		while(open) {
			System.out.println("1. Customer\n2. Delivery Partner\n3. Restaurant partner\n4. Close app");
			choice = sc.nextInt();
			switch(choice) {
			case 1: // CUSTOMER
				boolean customerLogged = false;
				System.out.println("1. Login\n2. Signup");
				choice = sc.nextInt();
				sc.nextLine();
				switch(choice) {
				case 1: // CUSTOMER LOGIN
					System.out.print("Enter Username: ");
					String username = sc.nextLine();
					if(customerDetails.containsKey(username)) {
						customerModel = customerDetails.get(username);
						customerView = new CustomerView();
						customerController = new CustomerController(customerModel, customerView);
						System.out.print("Enter password: ");
						String password = sc.nextLine();
						if(customerController.getCustomerPassword().equals(password)) {
							System.out.println("Logged in");
							customerLogged = true;
						}else {
							System.out.println("Invalid password. Try again");
							break;
						}
					}else {
						System.out.println("username does not exists. Try again.");
						break;
					}
					break;
				case 2: // CUSTOMER SIGNUP
					customerModel = new Customer();
					customerView = new CustomerView();
					customerController = new CustomerController(customerModel, customerView);
					System.out.print("Create Username: ");
					customerController.setCustomerName(sc.nextLine());
					System.out.print("Create Password: ");
					customerController.setCustomerPassword(sc.nextLine());
					System.out.print("Enter address: ");
					customerController.setCustomerAddress(sc.nextLine());
					System.out.print("Enter mobile number: ");
					customerController.setCustomerNumber(sc.nextLine());
					if(validate.validate(customerController.getCustomerName(), customerController.getCustomerPassword(), customerController.getCustomerAddress(), customerController.getCustomerNumber())) {
						if(customerDetails.containsKey(customerController.getCustomerName())) {
							System.out.println("Username already taken. Try Again");
							break;
						}
						customerDetails.put(customerController.getCustomerName(), customerModel);
						customerController.updateView();
						System.out.println("Signed up");
						customerLogged = true;
					}else {
						System.out.println("Try again.");
					}
					break;
				default:
					System.out.println("Invalid option");
					break;
				}
				while(customerLogged) {
					System.out.println("1. Order food\n2. Order groceries\n3. Buy membership\n4. View profile\n5. Logout");
					choice = sc.nextInt();
					switch(choice) {
					case 1: // ORDER FOOD
						System.out.println("Select restaurant");
						for(int i=0) {
							
						}
						break;
					case 2: // ORDER GROCERIES
						System.out.println("Coming soon.");
						break;
					case 3: // BUY MEMBERSHIP
						if(customerController.isMember()) {
							System.out.println("Already a member");
							break;
						}
						Membership membership = null;
						Subscription subscription = null;
						System.out.println("1. PRO Membership\n2. GOLD Membership");
						choice = sc.nextInt();
						switch(choice) {
						case 1:
							membership = new ProMembership();
							subscription = new Subscription(membership);
							subscription.subscribe();
							break;
						case 2:
							membership = new GoldMembership();
							subscription = new Subscription(membership);
							subscription.subscribe();
							break;
						default:
							System.out.println("Invalid option");
						}
						if(subscription != null) {
							subscription.getMembershipInfo();
							System.out.println("1. Pay and subcribe\n2. cancel");
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
									customerController.setMembership(membership);
									customerController.setMember(true);
									customerController.updateView();
									break;
								case 2:
									System.out.print("Enter UPI Id: ");
									String UpiId = sc.nextLine();
									method = new Upi();
									method.pay(UpiId, membership.price);
									customerController.setMembership(membership);
									customerController.setMember(true);
									customerController.updateView();
									break;
								default:
									System.out.println("Select valid payment option");
								}
								break;
							case 2:
								System.out.println("Cancelled");
								break;
							}
						}
						break;
					case 4: // VIEW PROFILE
						customerController.updateView();
						break;
					case 5: // LOGOUT
						customerLogged = false;
						System.out.println("Signed out.");
						break;
					default:
						System.out.println("Invalid option");
					}
				}
				break;
			case 2: // DELIVERY PARTNER
				boolean deliveryPartnerLogged = false;
				System.out.println("1. Login\n2. Signup");
				choice = sc.nextInt();
				sc.nextLine();
				switch(choice) {
				case 1: // DELIVERY PARTNER LOGIN
					System.out.print("Enter Partner ID: ");
					String partnerId = sc.nextLine();
					if(deliveryPartnerDetails.containsKey(partnerId)) {
						deliveryModel = deliveryPartnerDetails.get(partnerId);
						deliveryView = new DeliveryPartnerView();
						deliveryController = new DeliveryPartnerController(deliveryModel, deliveryView);
						System.out.print("Enter password: ");
						String password = sc.nextLine();
						if(deliveryController.getPartnerPassword().equals(password)) {
							System.out.println("Logged in");
							deliveryPartnerLogged = true;
						}else {
							System.out.println("Invalid password. Try again");
							break;
						}
					}else {
						System.out.println("Partner ID does not exists. Try again.");
						break;
					}
					break;
				case 2: // DELIVERY PARTNER SIGNUP
					deliveryModel = new DeliveryPartner();
					deliveryView = new DeliveryPartnerView();
					deliveryController = new DeliveryPartnerController(deliveryModel, deliveryView);
					System.out.print("Create Partner Id: ");
					deliveryController.setPartnerId(sc.nextLine());
					System.out.print("Create Password: ");
					deliveryController.setPartnerPassword(sc.nextLine());
					System.out.print("Enter Name: ");
					deliveryController.setPartnerName(sc.nextLine());
					System.out.print("Enter mobile number: ");
					deliveryController.setPartnerMobileNumber(sc.nextLine());
					System.out.print("Enter vehicle Reg no: ");
					deliveryController.setPartnerVehicleNumber(sc.nextLine());
					if(validate.validate(deliveryController.getPartnerName(), deliveryController.getPartnerPassword(), deliveryController.getPartnerId(), deliveryController.getPartnerMobileNumber(), deliveryController.getPartnerVehicleNumber())) {
						if(customerDetails.containsKey(deliveryController.getPartnerId())) {
							System.out.println("ID already taken. Try Again");
							break;
						}
						deliveryPartnerDetails.put(deliveryController.getPartnerId(), deliveryModel);
						deliveryController.updateView();
						System.out.println("Signed up");
						deliveryPartnerLogged = true;
					}else {
						System.out.println("Try again.");
					}
					break;
				default:
					System.out.println("Invalid option");
					break;
				}
				while(deliveryPartnerLogged) {
					System.out.println("1.View Food order\n2. View Grocery Order\n3. View Profile\n4. Withdraw Earnings\n5. logout");
					choice = sc.nextInt();
					switch(choice) {
					case 1: // VIEW FOOD ORDER
						break;
					case 2: // VIEW GROCERY ORDER
						break;
					case 3: // VIEW PROFILE
						deliveryController.updateView();
						break;
					case 4: // WITHDRAW EARNINGS
						System.out.println("Available amount: " + deliveryController.getPartnerEarnings());
						System.out.print("Enter amount to withdraw: ");
						int amount = sc.nextInt();
						sc.nextLine();
						if(amount <= deliveryController.getPartnerEarnings()) {
							WithdrawEarnings withdraw = new WithdrawEarnings();
							System.out.print("Enter account number: ");
							withdraw.withdraw(amount, sc.nextLine());
							deliveryController.setPartnerEarnings(deliveryController.getPartnerEarnings()-amount);
						}else {
							System.out.println("Requested amount is more than available earnings");
						}
						break;
					case 5: // DELIVERY PARTNER LOGOUT
						deliveryPartnerLogged = false;
						System.out.println("Signed out.");
						break;
					default:
						System.out.println("Invalid option");
					}
				}
				break;
			case 3: // RESTAURANT PARTNER
				boolean restaurantLogged = false;
				System.out.println("1. Login\n2. Register");
				choice = sc.nextInt();
				sc.nextLine();
				switch(choice) {
				case 1: // RESTAURANT LOGIN
					System.out.print("Enter Restaurant EmailId: ");
					String restaurantEmailId = sc.nextLine();
					if(restaurantDetails.containsKey(restaurantEmailId)) {
						restaurantModel = restaurantDetails.get(restaurantEmailId);
						restaurantView = new RestaurantPartnerView();
						restaurantController = new RestaurantPartnerController(restaurantModel, restaurantView);
						System.out.print("Enter password: ");
						String password = sc.nextLine();
						if(restaurantController.getRestaurantPassword().equals(password)) {
							System.out.println("Logged in");
							restaurantLogged = true;
						}else {
							System.out.println("Invalid password. Try again");
							break;
						}
					}else {
						System.out.println("Email ID does not exists. Signup or Try again.");
						break;
					}
					break;
				case 2: // RESTAURANT SIGNUP
					restaurantModel = new RestaurantPartner();
					restaurantView = new RestaurantPartnerView();
					restaurantController = new RestaurantPartnerController(restaurantModel, restaurantView);
					System.out.print("Enter Email Id: ");
					restaurantController.setRestaurantEmailId(sc.nextLine());
					if(restaurantDetails.containsKey(restaurantController.getRestaurantEmailId())) {
						System.out.println("Email Id exists already. Login to continue");
						break;
					}
					if(validate.validate(restaurantController.getRestaurantEmailId())) {
						System.out.println("Otp sent to your email id");
						int generatedOtp = otp.generateOtp();
						System.out.println("OTP: " + generatedOtp);
						System.out.print("Enter otp to verify: ");
						int enteredOtp = sc.nextInt();
						if(!validate.validate(generatedOtp, enteredOtp)) {
							break;
						}
					}else {
						break;
					}
					sc.nextLine();
					System.out.println("Enter Password: ");
					restaurantController.setRestaurantPassword(sc.nextLine());
					System.out.println("Re-Enter Password: ");
					String rePassword = sc.nextLine();
					if(!validate.validate(restaurantController.getRestaurantPassword(), rePassword)) {
						break;
					}
					System.out.print("Enter Restaurant Name: ");
					restaurantController.setRestaurantName(sc.nextLine());
					System.out.print("Enter mobile number: ");
					restaurantController.setRestaurantMobileNumber(sc.nextLine());
					System.out.print("Enter Restaurant Location: ");
					restaurantController.setRestaurantLocation(sc.nextLine());
					if(validate.validate(restaurantController.getRestaurantName(), restaurantController.getRestaurantMobileNumber(), restaurantController.getRestaurantLocation())) {
						restaurantDetails.put(restaurantController.getRestaurantEmailId(), restaurantModel);
						restaurantController.updateView();
						System.out.println("Signed up");
						restaurantLogged = true;
					}else {
						System.out.println("Try again.");
					}
					break;
				default:
					System.out.println("Invalid option");
				}
				while(restaurantLogged) {
					System.out.println("1. View Orders\n2. Add/Edit menu\n3. View Profile\n4. View Menu\n5. Logout");
					choice = sc.nextInt();
					switch(choice) {
					case 1: // VIEW ORDER
						break;
					case 2: // ADD OR EDIT MENU
						FoodItem food;
						ArrayList<FoodItem> menu = restaurantController.getRestaurantMenu();
						System.out.println("1. Add item\n2. Edit item");
						choice = sc.nextInt();
						sc.nextLine();
						switch(choice) {
						case 1: //  ADD FOOD
							food = new FoodItem();
							System.out.print("Enter food name: ");
							food.foodName = sc.nextLine();
							System.out.print("Enter food cost: ");
							food.foodCost = sc.nextInt();
							sc.nextLine();
							menu.add(food);
							restaurantController.setRestaurantMenu(menu);
							restaurantController.viewMenu();
							break;
						case 2: // EDIT FOOD
							restaurantController.viewMenu();
							System.out.println("Select food to edit");
							int item = sc.nextInt();
							if(item > menu.size()) {
								System.out.println("Item not available.");
							}
							System.out.println("1. edit item\n2. remove item");
							choice = sc.nextInt();
							switch(choice) {
							case 1: // EDIT ITEM
								sc.nextLine();
								System.out.print("Enter food name: ");
								menu.get(item-1).foodName = sc.nextLine();
								System.out.print("Enter food cost: ");
								menu.get(item-1).foodCost = sc.nextInt();
								sc.nextLine();
								break;
							case 2: // REMOVE ITEM
								menu.remove(item-1);
								break;
							default:
								System.out.println("invalid option");
							}
							restaurantController.setRestaurantMenu(menu);
							restaurantController.viewMenu();
							break;
						default:
							System.out.println("Invalid option");
						}
						break;
					case 3: // VIEW PROFILE
						restaurantController.updateView();
						break;
					case 4: // VIEW MENU
						restaurantController.viewMenu();
						break;
					case 5: // LOGOUT
						restaurantLogged = false;
						System.out.println("logged out");
						break;
					default:
						System.out.println("Invalid option");
					}
				}
				break;
			case 4: // CLOSE APP
				System.out.println("App closed");
				open = false;
				break;
			default:
				System.out.println("Invalid option\n");		
			}
		}
	}
}