package customer;

public class CustomerView {
	public void printCustomerDetails(String customerName, String customerNumber, String customerAddress, Membership membership, boolean isMember) {
		System.out.println("Name: " + customerName);
		System.out.println("Mobile number: " + customerNumber);
		System.out.println("Address: " + customerAddress);
		if(isMember) {
			membership.getMembershipInfo();
		}else {
			System.out.println("Not a member");
		}
	}
}