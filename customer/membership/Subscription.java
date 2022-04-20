package customer.membership;

public class Subscription{
	Membership membership;
	public Subscription(Membership membership){
		this.membership = membership;
	}
	public void subscribe(){
		membership.setMembershipDetails();
	}
	public void getMembershipInfo() {
		membership.getMembershipInfo();
	}
}