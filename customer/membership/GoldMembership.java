package customer.membership;

public class GoldMembership extends Membership{

	public void setMembershipDetails() {
		price = 900;
		benefits = "Free delivery on all orders";
		membershipType = MembershipType.GOLD;
		membershipValidity = "12 months";
	}
	
	public void getMembershipInfo() {
		System.out.println("Membership Type: "+ membershipType);
		System.out.println("Price: "+ price);
		System.out.println("Validity: "+ membershipValidity);
		System.out.println("Benefits: "+ benefits);
	}
}