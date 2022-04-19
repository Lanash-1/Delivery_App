package customer;

public class Membership {
	int price;
	String benefits;
	String membershipType;
	String membershipValidity;
	void setMembershipDetails() {
		price = 0;
		benefits = "";
		membershipType = "";
		membershipValidity = "";
	}
	public void getMembershipInfo() {
		System.out.println("Choose any membership");
	}
}

class ProMembership extends Membership{
	int price;
	String benefits;
	String membershipType;
	String membershipValidity;
	void setMembershipDetails() {
		price = 100;
		benefits = "Free delivery on all orders";
		membershipType = "PRO";
		membershipValidity = "1 month";
	}
	public void getMembershipInfo() {
		System.out.println("Membership Type: "+ membershipType);
		System.out.println("Price: "+ price);
		System.out.println("Validity: "+ membershipValidity);
		System.out.println("Benefits: "+ benefits);
	}
}

class GoldMembership extends Membership{
	int price;
	String benefits;
	String membershipType;
	String membershipValidity;
	void setMembershipDetails() {
		price = 900;
		benefits = "Free delivery on all orders";
		membershipType = "GOLD";
		membershipValidity = "12 months";
	}
	public void getMembershipInfo() {
		System.out.println("Membership Type: "+ membershipType);
		System.out.println("Price: "+ price);
		System.out.println("Validity: "+ membershipValidity);
		System.out.println("Benefits: "+ benefits);
	}
}