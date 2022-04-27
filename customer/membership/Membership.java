package customer.membership;

abstract public class Membership {
	public int price;
	public String benefits;
	public String membershipType;
	public String membershipValidity;
	
	abstract void setMembershipDetails();
	
	public void getMembershipInfo() {
		System.out.println("Choose any membership");
	}
}