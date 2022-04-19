package payment;

public interface PaymentMethod {
	void pay(String fromAccount, int amount);
}
