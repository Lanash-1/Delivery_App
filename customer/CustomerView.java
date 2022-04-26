package customer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import customer.membership.Membership;

public class CustomerView {
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
			writer.write("\nMembership Type: " + membership.membershipType);
			writer.write("\nPrice: " + membership.price);
			writer.write("\nValidity: " + membership.membershipValidity);
			writer.write("\nBenefits: " + membership.benefits);
		}else {
			writer.write("\nMember: Not a member");
		}
		writer.close();
		
		Scanner sc = new Scanner(file);
		while(sc.hasNextLine()) {
			System.out.println(sc.nextLine());
		}
	}
}