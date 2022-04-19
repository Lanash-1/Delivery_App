package payment;

public class Upi implements PaymentMethod {
	public void pay(String fromAccount, int amount) {
		System.out.println("Successfully paid: Rs" + amount);
		System.out.println("Amount received from upi id: "+ fromAccount);
	}
}
