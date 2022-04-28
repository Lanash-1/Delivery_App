package customer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import customer.membership.Membership;
import validation.ValidationUtility;

public class CustomerView {
	String customerName, password, repassword, mobileNumber, address;
	Scanner sc = new Scanner(System.in);
	
	public void printCustomerDetails(String customerName, String customerNumber, String customerAddress, Membership membership, boolean isMember, String customerEmail) throws IOException {
		File file = new File("customerProfile.txt");
				
		if(!file.createNewFile()) {	
			file.delete();
			file.createNewFile();
		}
		FileWriter writer = new FileWriter(file);
		writer.write("Name: " + customerName);
		writer.write("\nEmail ID: " + customerEmail);
		writer.write("\nMobile number: " + customerNumber);
		writer.write("\nAddress: " + customerAddress);
		if(isMember) {
			writer.write("\n*****Membership details*****");
			writer.write("\nMembership Type: " + membership.membershipType);
			writer.write("\nPrice: " + membership.price);
			writer.write("\nValidity: " + membership.membershipValidity);
			writer.write("\nBenefits: " + membership.benefits);
		}else {
			writer.write("\nMembership status: Not a member");
		}
		writer.close();
		
		Scanner read = new Scanner(file);
		while(read.hasNextLine()) {
			System.out.println(read.nextLine());
		}
	}
	
	public void getCustomerName() {
		System.out.println("Create Username: ");
		customerName = sc.nextLine();
	}
	
	public void getCustomerInfo() {
		System.out.print("Enter address: ");
		address = sc.nextLine();
		System.out.print("Enter mobile number: ");
		mobileNumber = sc.nextLine();
	}
	
	public void getPassword() {
		System.out.println("Enter password: ");
		password = sc.nextLine();
		System.out.println("Re-Enter password: ");
		repassword = sc.nextLine();
	}
}