package payment;

public class Card implements PaymentMethod {
	public void pay(String fromAccount, int amount) {
		System.out.println("Successfully paid: Rs" + amount);
		System.out.println("Amount received from card number: "+fromAccount);
	}
}
