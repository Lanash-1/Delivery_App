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
import foodorder.FoodOrderInfo;
import foodorder.FoodOrderInfoController;
import foodorder.FoodOrderInfoView;
import groceryorder.Grocery;
import groceryorder.GroceryOrder;
import groceryorder.GroceryOrderController;
import groceryorder.GroceryOrderView;
import payment.Card;
import payment.PaymentMethod;
import payment.Upi;
import payment.WithdrawEarnings;
import restaurant.FoodItem;
import restaurant.RestaurantPartner;
import restaurant.RestaurantPartnerController;
import restaurant.RestaurantPartnerView;

public class App {	
	
	public static final int CUSTOMER = 1;
	public static final int DELIVERYPARTNER = 2;
	public static final int RESTAURANTPARTNER = 3;
	public static final int CLOSEAPP = 4;
	public static final int LOGIN = 1;
	public static final int SIGNUP = 2;
	public static final int VIEWPROFILE = 4;
	public static final int LOGOUT = 5;
	public static final int BACK = 3;
	public static final int FOODORDER = 1;
	public static final int GROCERYORDER = 2;
	public static final int PAYNOW = 1;
	public static final int CASHONDELIVERY = 2;
	public static final int BUYMEMBERSHIP = 3;
	public static final int PRO = 1;
	public static final int GOLD = 2;
	public static final int CARD = 1;
	public static final int UPI = 2;
	public static final int ACCEPT = 1;
	public static final int CANCEL = 2;
	public static final int WITHDRAW = 3;
	public static final int VIEWORDER = 1;
	public static final int VIEWMENU = 3;
	public static final int ADDOREDITMENU = 2;
	public static final int EDIT = 2;
	public static final int REMOVE = 1;
	public static final int ADD = 1;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<String, Customer> customerDetails = new HashMap<String, Customer>();
		CustomerController customerController = null;
		HashMap<String, DeliveryPartner> deliveryPartnerDetails = new HashMap<String, DeliveryPartner>();
		DeliveryPartner deliveryModel;
		DeliveryPartnerView deliveryView;
		DeliveryPartnerController deliveryController = null;
		HashMap<String, RestaurantPartner> restaurantDetails = new HashMap<String, RestaurantPartner>();
		ArrayList<RestaurantPartner> restaurant = new ArrayList<RestaurantPartner>();
		RestaurantPartner restaurantModel;
		RestaurantPartnerView restaurantView;
		RestaurantPartnerController restaurantController = null;
		ArrayList<FoodOrderInfo> foodOrders = new ArrayList<FoodOrderInfo>();
		FoodOrderInfo foodOrderModel;
		FoodOrderInfoView foodOrderView;
		FoodOrderInfoController foodOrderController;
		ArrayList<FoodOrderInfo> foodOrdersToDeliver = new ArrayList<FoodOrderInfo>();
		FoodOrderInfo foodToDeliver;
		ArrayList<Grocery> groceryList = new ArrayList<Grocery>();
		Grocery grocery1 = new Grocery(1,"chips",5);
		groceryList.add(grocery1);
		Grocery grocery2 = new Grocery(2,"biscuits",10);
		groceryList.add(grocery2);
		Grocery grocery3 = new Grocery(3,"milk",20);
		groceryList.add(grocery3);
		ArrayList<GroceryOrder> groceryOrderList = new ArrayList<GroceryOrder>();
		GroceryOrder groceryOrderModel = new GroceryOrder();
		GroceryOrderView groceryOrderView = new GroceryOrderView();
		GroceryOrderController groceryOrderController = new GroceryOrderController(groceryOrderModel, groceryOrderView);
		boolean open = true;
		int choice = 0;
		while(open) {
			System.out.println("1. Customer\n2. Delivery Partner\n3. Restaurant partner\n4. Close app");
			try {
			choice = sc.nextInt();
			}catch (Exception e) {
				System.out.println("Something's wrong.");
				sc.nextLine();
			}
			switch(choice) {
			case CUSTOMER: // CUSTOMER
				Customer customerModel = null;
				CustomerView customerView;
				boolean customerLogged = false;
				boolean back = false; 
				while(!back) {
				System.out.println("1. Login\n2. Signup\n3. Back");
				choice = sc.nextInt();
				sc.nextLine();
				switch(choice) {
				case LOGIN: // CUSTOMER LOGIN
					System.out.print("Enter Email ID: ");
					String emailId = sc.nextLine();
					if(customerDetails.containsKey(emailId)) {
						customerModel = customerDetails.get(emailId);
						customerView = new CustomerView();
						customerController = new CustomerController(customerModel, customerView);
						System.out.print("Enter password: ");
						String password = sc.nextLine();
						if(customerController.getCustomerPassword().equals(password)) {
							System.out.println("Logged in");
							back = true;
							customerLogged = true;
						}else {
							System.out.println("Invalid password. Try again");
							break;
						}
					}else {
						System.out.println("Email ID does not exists. Try again.");
						break;
					}
					break;
				case SIGNUP: // CUSTOMER SIGNUP
					customerModel = new Customer();
					customerView = new CustomerView();
					customerController = new CustomerController(customerModel, customerView);
					System.out.print("Enter Email Id: ");
					customerController.setCustomerEmail(sc.nextLine());
					if(customerDetails.containsKey(customerController.getCustomerEmail())) {
						System.out.println("Email Id exists already. Login to continue");
						break;
					}
					if(customerController.validate(customerController.getCustomerEmail())) {
						System.out.println("Otp sent to your email id");
						int generatedOtp = customerController.generateOtp();
						System.out.println("OTP: " + generatedOtp);
						System.out.print("Enter otp to verify: ");
						int enteredOtp = sc.nextInt();
						if(!customerController.validate(generatedOtp, enteredOtp)) {
							break;
						}
					}else {
						break;
					}
					sc.nextLine();
					System.out.print("Create Username: ");
					customerController.setCustomerName(sc.nextLine());
					System.out.print("Create Password: ");
					customerController.setCustomerPassword(sc.nextLine());
					System.out.println("Re-Enter Password: ");
					String rePassword = sc.nextLine();
					if(!customerController.validate(customerController.getCustomerPassword(), rePassword)) {
						break;
					}
					System.out.print("Enter address: ");
					customerController.setCustomerAddress(sc.nextLine());
					System.out.print("Enter mobile number: ");
					customerController.setCustomerNumber(sc.nextLine());
					if(customerController.validate(customerController.getCustomerName(), customerController.getCustomerNumber(),customerController.getCustomerAddress())) {
						customerDetails.put(customerController.getCustomerEmail(), customerModel);
						customerController.updateView();
						System.out.println("Signed up");
						back = true;
						customerLogged = true;
					}else {
						System.out.println("Try again.");
					}
					break;
				case BACK:
					back = true;
					break;
				default:
					System.out.println("Invalid option");
					break;
				}
				}
				while(customerLogged) {
					System.out.println("1. Order food\n2. Order groceries\n3. Buy membership\n4. View profile\n5. Logout");
					choice = sc.nextInt();
					switch(choice) {
					case FOODORDER: // ORDER FOOD
						if(restaurant.size() == 0) {
							System.out.println("no restaurants available.");
							break;
						}
						System.out.println("Select restaurant");
						for(int i=1; i<=restaurant.size(); i++) {
							System.out.println(i+". "+restaurant.get(i-1).getRestaurantName());
						}
						int selectedRestaurant = sc.nextInt();
						restaurantModel = restaurant.get(selectedRestaurant-1);
						restaurantView = new RestaurantPartnerView();
						restaurantController = new RestaurantPartnerController(restaurantModel, restaurantView);
						System.out.println("Select food");
						restaurantController.viewMenu();
						int selectedFood = sc.nextInt();
						foodOrderModel = new FoodOrderInfo();
						foodOrderView = new FoodOrderInfoView();
						foodOrderController = new FoodOrderInfoController(foodOrderModel, foodOrderView);
						foodOrderController.setFoodItem(restaurantController.getRestaurantMenu().get(selectedFood-1));
						sc.nextLine();
						System.out.print("Enter Quantity: ");
						foodOrderController.setQuantity(sc.nextInt());
						foodOrderController.setCustomer(customerModel);
						foodOrderController.setRestaurant(restaurantModel);
						int totalBill = foodOrderController.getFoodItem().foodCost * foodOrderController.getQuantity();
						if(customerController.isMember()) {
							System.out.println("Bill: " + totalBill);
							System.out.println("No delivery charges");
							System.out.println("Total bill: " + totalBill);
						}else {
							System.out.println("Bill: " + totalBill);
							System.out.println("Delivery charges: Rs.25");
							totalBill += 25;
							System.out.println("Total bill: " + totalBill);
						}
						foodOrderController.setTotalBill(totalBill);
						System.out.println("1. Pay now\n2. Cash on delivery");
						choice = sc.nextInt();
						switch(choice) {
						case PAYNOW: // PAY NOW
							sc.nextLine();
							System.out.println("1. Pay using card\n2. Pay using upi");
							choice = sc.nextInt();
							sc.nextLine();
							PaymentMethod method;
							switch(choice) {
							case CARD:
								System.out.print("Enter card number: ");
								String cardNumber = sc.nextLine();
								method = new Card();
								method.pay(cardNumber, foodOrderController.getTotalBill());
								foodOrderController.setPaid(true);
								foodOrders = restaurantController.getOrders();
								foodOrders.add(foodOrderModel);
								restaurantController.setOrders(foodOrders);
								System.out.println("Order placed");
								break;
							case UPI:
								System.out.print("Enter UPI Id: ");
								String UpiId = sc.nextLine();
								method = new Upi();
								method.pay(UpiId, foodOrderController.getTotalBill());
								foodOrderController.setPaid(true);
								foodOrders = restaurantController.getOrders();
								foodOrders.add(foodOrderModel);
								restaurantController.setOrders(foodOrders);
								System.out.println("Order placed");
								break;
							default:
								System.out.println("Select valid payment option");
							}
							break;
						case CASHONDELIVERY: // CASH ON DELIVERY
							foodOrderController.setPaid(false);
							foodOrders = restaurantController.getOrders();
							foodOrders.add(foodOrderModel);
							restaurantController.setOrders(foodOrders);
							System.out.println("Order placed");
							break;
						default:
							System.out.println("Invalid option. Order Again");
						}
						break;
					case GROCERYORDER: // ORDER GROCERIES
						for(Grocery item : groceryList) {
							System.out.println(item.productId+". "+item.productName+" - "+item.productPrice);
						}
						System.out.println("Select grocery");
						int selectedGrocery = sc.nextInt();
						sc.nextLine();
						System.out.print("Enter quantity: ");
						int groceryQuantity = sc.nextInt();
						groceryOrderController.setCustomer(customerModel);
						groceryOrderController.setGrocery(groceryList.get(selectedGrocery-1));
						groceryOrderController.setQuantity(groceryQuantity);
						int groceryBill = groceryOrderController.getGrocery().productPrice * groceryQuantity;
						if(customerController.isMember()) {
							System.out.println("Bill: " + groceryBill);
							System.out.println("No delivery charges");
							System.out.println("Total bill: " + groceryBill);
						}else {
							System.out.println("Bill: " + groceryBill);
							System.out.println("Delivery charges: Rs.25");
							groceryBill += 25;
							System.out.println("Total bill: " + groceryBill);
						}
						groceryOrderController.setTotalBill(groceryBill);
						System.out.println("1. Pay now\n2. Cash on delivery");
						choice = sc.nextInt();
						switch(choice) {
						case PAYNOW: // PAY NOW
							sc.nextLine();
							System.out.println("1. Pay using card\n2. Pay using upi");
							choice = sc.nextInt();
							sc.nextLine();
							PaymentMethod method;
							switch(choice) {
							case CARD:
								System.out.print("Enter card number: ");
								String cardNumber = sc.nextLine();
								method = new Card();
								method.pay(cardNumber, groceryOrderController.getTotalBill());
								groceryOrderController.setPaid(true);
								groceryOrderList.add(groceryOrderModel);
								System.out.println("Order placed");
								break;
							case UPI:
								System.out.print("Enter UPI Id: ");
								String UpiId = sc.nextLine();
								method = new Upi();
								method.pay(UpiId, groceryOrderController.getTotalBill());
								groceryOrderController.setPaid(true);
								groceryOrderList.add(groceryOrderModel);
								System.out.println("Order placed");
								break;
							default:
								System.out.println("Select valid payment option");
							}
							break;
						case CASHONDELIVERY: // CASH ON DELIVERY
							groceryOrderController.setPaid(false);
							groceryOrderList.add(groceryOrderModel);
							System.out.println("Order placed");
							break;
						default:
							System.out.println("Invalid option. Order Again");
						}
						break;
					case BUYMEMBERSHIP: // BUY MEMBERSHIP
						if(customerController.isMember()) {
							System.out.println("Already a member");
							break;
						}
						Membership membership = null;
						Subscription subscription = null;
						System.out.println("1. PRO Membership\n2. GOLD Membership");
						choice = sc.nextInt();
						switch(choice) {
						case PRO: // PRO MEMBERSHIP
							membership = new ProMembership();
							subscription = new Subscription(membership);
							subscription.subscribe();
							break;
						case GOLD: // GOLD MEMBERSHIP
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
							case PAYNOW:
								System.out.println("1. Pay using card\n2. Pay using upi");
								choice = sc.nextInt();
								sc.nextLine();
								PaymentMethod method;
								switch(choice) {
								case CARD: // CARD
									System.out.print("Enter card number: ");
									String cardNumber = sc.nextLine();
									method = new Card();
									method.pay(cardNumber, membership.price);
									customerController.setMembership(membership);
									customerController.setMember(true);
									customerController.updateView();
									break;
								case UPI: // UPI
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
							case CANCEL:
								System.out.println("Cancelled");
								break;
							}
						}
						break;
					case VIEWPROFILE: // VIEW PROFILE
						customerController.updateView();
						break;
					case LOGOUT: // LOGOUT
						customerLogged = false;
						System.out.println("Signed out.");
						break;
					default:
						System.out.println("Invalid option");
					}
				}
				break;
			case DELIVERYPARTNER: // DELIVERY PARTNER
				boolean deliveryPartnerLogged = false;
				System.out.println("1. Login\n2. Signup");
				choice = sc.nextInt();
				sc.nextLine();
				switch(choice) {
				case LOGIN: // DELIVERY PARTNER LOGIN
					System.out.print("Enter Email ID: ");
					String emailId = sc.nextLine();
					if(deliveryPartnerDetails.containsKey(emailId)) {
						deliveryModel = deliveryPartnerDetails.get(emailId);
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
						System.out.println("Email Id does not exists. Try again.");
						break;
					}
					break;
				case SIGNUP: // DELIVERY PARTNER SIGNUP
					deliveryModel = new DeliveryPartner();
					deliveryView = new DeliveryPartnerView();
					deliveryController = new DeliveryPartnerController(deliveryModel, deliveryView);
					System.out.print("Enter Email Id: ");
					deliveryController.setPartnerEmail(sc.nextLine());
					if(deliveryPartnerDetails.containsKey(deliveryController.getPartnerEmail())) {
						System.out.println("Email Id exists already. Login to continue");
						break;
					}
					if(deliveryController.validate(deliveryController.getPartnerEmail())) {
						System.out.println("Otp sent to your email id");
						int generatedOtp = deliveryController.generateOtp();
						System.out.println("OTP: " + generatedOtp);
						System.out.print("Enter otp to verify: ");
						int enteredOtp = sc.nextInt();
						if(!deliveryController.validate(generatedOtp, enteredOtp)) {
							break;
						}
					}else {
						break;
					}
					sc.nextLine();
					System.out.print("Create Partner Id: ");
					deliveryController.setPartnerId(sc.nextLine());
					System.out.print("Create Password: ");
					deliveryController.setPartnerPassword(sc.nextLine());
					System.out.println("Re-Enter Password: ");
					String rePassword = sc.nextLine();
					if(!deliveryController.validate(deliveryController.getPartnerPassword(), rePassword)) {
						break;
					}
					System.out.print("Enter Name: ");
					deliveryController.setPartnerName(sc.nextLine());
					System.out.print("Enter mobile number: ");
					deliveryController.setPartnerMobileNumber(sc.nextLine());
					System.out.print("Enter vehicle Reg no: ");
					deliveryController.setPartnerVehicleNumber(sc.nextLine());
					if(deliveryController.validate(deliveryController.getPartnerName(), deliveryController.getPartnerId(), deliveryController.getPartnerMobileNumber(), deliveryController.getPartnerVehicleNumber())) {
						deliveryPartnerDetails.put(deliveryController.getPartnerEmail(), deliveryModel);
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
					System.out.println("1.View Food order\n2. View Grocery Order\n3. Withdraw Earnings\n4. View Profile\n5. logout");
					choice = sc.nextInt();
					switch(choice) {
					case FOODORDER: // VIEW FOOD ORDER TO DELIVER
						if(foodOrdersToDeliver.size() > 0) {
							foodOrderModel = foodOrdersToDeliver.get(0);
							foodOrderView = new FoodOrderInfoView();
							foodOrderController = new FoodOrderInfoController(foodOrderModel, foodOrderView);
							foodOrderController.viewFoodOrderInfo();
							System.out.println("1. Accept order\n2. Cancel order");
							choice = sc.nextInt();
							switch(choice) {
							case ACCEPT:
								System.out.println("Order pickedUp");
								if(!foodOrderController.isPaid()) {
									System.out.println("Amount collected");
								}else {
									System.out.println("Amount paid online");
								}
								System.out.println("Order delivered");
								System.out.println("Ride Earnings: " + ((foodOrderController.getTotalBill())*10)/100);
								foodOrdersToDeliver.remove(0);
								deliveryController.setPartnerEarnings(deliveryController.getPartnerEarnings() + ((foodOrderController.getTotalBill())*10)/100);
								break;
							case CANCEL:
								System.out.println("Skipped order");
								break;
							default:
								System.out.println("Invalid option");
							}
						}else {
							System.out.println("No orders to deliver");
						}
						break;
					case GROCERYORDER: // VIEW GROCERY ORDER
						if(groceryOrderList.size() > 0) {
							groceryOrderModel = groceryOrderList.get(0);
							groceryOrderController = new GroceryOrderController(groceryOrderModel, groceryOrderView);
							groceryOrderController.viewGroceryOrder();
							System.out.println("1. Accept order\n2. Cancel order");
							choice = sc.nextInt();
							switch(choice) {
							case ACCEPT:
								System.out.println("Order pickedUp");
								if(!groceryOrderController.isPaid()) {
									System.out.println("Amount collected");
								}else {
									System.out.println("Amount paid online");
								}
								System.out.println("Order delivered");
								System.out.println("Ride Earnings: " + ((groceryOrderController.getTotalBill())*5)/100);
								groceryOrderList.remove(0);
								deliveryController.setPartnerEarnings(deliveryController.getPartnerEarnings() + ((groceryOrderController.getTotalBill())*5)/100);
								break;
							case CANCEL:
								System.out.println("Skipped order");
								break;
							default:
								System.out.println("Invalid option");
							}
						}else {
							System.out.println("No orders to deliver");
						}
						break;
					case VIEWPROFILE: // VIEW PROFILE
						deliveryController.updateView();
						break;
					case WITHDRAW: // WITHDRAW EARNINGS
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
					case LOGOUT: // DELIVERY PARTNER LOGOUT
						deliveryPartnerLogged = false;
						System.out.println("Signed out.");
						break;
					default:
						System.out.println("Invalid option");
					}
				}
				break;
			case RESTAURANTPARTNER: // RESTAURANT PARTNER
				boolean restaurantLogged = false;
				System.out.println("1. Login\n2. Register");
				choice = sc.nextInt();
				sc.nextLine();
				switch(choice) {
				case LOGIN: // RESTAURANT LOGIN
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
				case SIGNUP: // RESTAURANT SIGNUP
					restaurantModel = new RestaurantPartner();
					restaurantView = new RestaurantPartnerView();
					restaurantController = new RestaurantPartnerController(restaurantModel, restaurantView);
					System.out.print("Enter Email Id: ");
					restaurantController.setRestaurantEmailId(sc.nextLine());
					if(restaurantDetails.containsKey(restaurantController.getRestaurantEmailId())) {
						System.out.println("Email Id exists already. Login to continue");
						break;
					}
					if(restaurantController.validate(restaurantController.getRestaurantEmailId())) {
						System.out.println("Otp sent to your email id");
						int generatedOtp = restaurantController.generateOtp();
						System.out.println("OTP: " + generatedOtp);
						System.out.print("Enter otp to verify: ");
						int enteredOtp = sc.nextInt();
						if(!restaurantController.validate(generatedOtp, enteredOtp)) {
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
					if(!restaurantController.validate(restaurantController.getRestaurantPassword(), rePassword)) {
						break;
					}
					System.out.print("Enter Restaurant Name: ");
					restaurantController.setRestaurantName(sc.nextLine());
					System.out.print("Enter mobile number: ");
					restaurantController.setRestaurantMobileNumber(sc.nextLine());
					System.out.print("Enter Restaurant Location: ");
					restaurantController.setRestaurantLocation(sc.nextLine());
					if(restaurantController.validate(restaurantController.getRestaurantName(), restaurantController.getRestaurantMobileNumber(), restaurantController.getRestaurantLocation())) {
						restaurantDetails.put(restaurantController.getRestaurantEmailId(), restaurantModel);
						restaurantController.updateView();
						System.out.println("Signed up");
						restaurant.add(restaurantModel);
						restaurantLogged = true;
					}else {
						System.out.println("Try again.");
					}
					break;
				default:
					System.out.println("Invalid option");
				}
				while(restaurantLogged) {
					System.out.println("1. View Orders\n2. Add/Edit menu\n3. View Menu\n4. View Profile\n5. Logout");
					choice = sc.nextInt();
					switch(choice) {
					case VIEWORDER: // VIEW ORDER
						restaurantController.viewOrder();
						if(restaurantController.getOrders().size() > 0) {							
							sc.nextLine();
							System.out.print("Select order to prepare: ");
							int orderToComplete = sc.nextInt();
							sc.nextLine();
							System.out.println("Completed preparation of the order");
							foodOrdersToDeliver.add(restaurantController.getOrders().get(orderToComplete-1));
							foodOrders = restaurantController.getOrders();
							foodOrders.remove(orderToComplete-1);
							restaurantController.setOrders(foodOrders);
						}
						break;
					case ADDOREDITMENU: // ADD OR EDIT MENU
						FoodItem food;
						ArrayList<FoodItem> menu = restaurantController.getRestaurantMenu();
						System.out.println("1. Add item\n2. Edit item");
						choice = sc.nextInt();
						sc.nextLine();
						switch(choice) {
						case ADD: //  ADD FOOD
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
						case EDIT: // EDIT FOOD
							restaurantController.viewMenu();
							System.out.println("Select food to edit");
							int item = sc.nextInt();
							if(item > menu.size()) {
								System.out.println("Item not available.");
							}
							System.out.println("1. Remove item\n2. Edit item");
							choice = sc.nextInt();
							switch(choice) {
							case EDIT: // EDIT ITEM
								sc.nextLine();
								System.out.print("Enter food name: ");
								menu.get(item-1).foodName = sc.nextLine();
								System.out.print("Enter food cost: ");
								menu.get(item-1).foodCost = sc.nextInt();
								sc.nextLine();
								break;
							case REMOVE: // REMOVE ITEM
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
					case VIEWPROFILE: // VIEW PROFILE
						restaurantController.updateView();
						break;
					case VIEWMENU: // VIEW MENU
						restaurantController.viewMenu();
						break;
					case LOGOUT: // LOGOUT
						restaurantLogged = false;
						System.out.println("logged out");
						break;
					default:
						System.out.println("Invalid option");
					}
				}
				break;
			case CLOSEAPP: // CLOSE APP
				System.out.println("App closed");
				open = false;
				break;
			default:
				System.out.println("Invalid option\n");		
			}
		}
	}
}