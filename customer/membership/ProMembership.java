package customer.membership;

public class ProMembership extends Membership{

	public void setMembershipDetails() {
		price = 100;
		benefits = "Free delivery on all orders";
		membershipType = MembershipType.PRO;
		membershipValidity = "1 month";
	}
	
	public void getMembershipInfo() {
		System.out.println("Membership Type: "+ membershipType);
		System.out.println("Price: "+ price);
		System.out.println("Validity: "+ membershipValidity);
		System.out.println("Benefits: "+ benefits);
	}
}
