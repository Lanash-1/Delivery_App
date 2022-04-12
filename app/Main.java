package app;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("1.Customer\n2.Delivery partner\n3.Restaurant partner");
		Map<String, String> customerDetails = new HashMap<String, String>();
		int choice = sc.nextInt();
		switch(choice) {
		case 1:
			System.out.println("1.Login\n2.New user? sign up.");
			choice = sc.nextInt();
			switch(choice) {
			case 1:
				System.out.print("Enter username: ");
				String username = sc.nextLine();
				System.out.print("Enter password: ");
				String password = sc.nextLine();
				
				break;
			case 2:
				break;
			}
			break;
		case 2:
			break;
		case 3:
			break;
		default:
			System.out.println("Invalid option");
		}
	}
}
