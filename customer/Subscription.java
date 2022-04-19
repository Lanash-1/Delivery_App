package customer;

public class Subscription{
	Membership membership;
	Subscription(Membership membership){
		this.membership = membership;
	}
	public void subscribe(){
		membership.setMembershipDetails();
	}
	public void getMembershipInfo() {
		membership.getMembershipInfo();
	}
}