package customer;

import customer.membership.Membership;

public class CustomerView {
	public void printCustomerDetails(String customerName, String customerNumber, String customerAddress, Membership membership, boolean isMember, String customerEmail) {
		System.out.println("Name: " + customerName);
		System.out.println("Email Id: " + customerEmail);
		System.out.println("Mobile number: " + customerNumber);
		System.out.println("Address: " + customerAddress);
		if(isMember) {
			membership.getMembershipInfo();
		}else {
			System.out.println("Not a member");
		}
	}
}