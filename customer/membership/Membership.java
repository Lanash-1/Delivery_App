package customer.membership;

public class Membership {
	public int price;
	public String benefits;
	public String membershipType;
	public String membershipValidity;
	
	public void setMembershipDetails() {
		price = 20;
		benefits = "";
		membershipType = "";
		membershipValidity = "";
	}
	
	public void getMembershipInfo() {
		System.out.println("Choose any membership");
	}
}