package customer.membership;

abstract public class Membership {
	public int price;
	public String benefits;
	public MembershipType membershipType;
	public String membershipValidity;
	enum MembershipType{
		PRO, GOLD
	}
	abstract void setMembershipDetails();
	
	public void getMembershipInfo() {
		System.out.println("Choose any membership");
	}
}