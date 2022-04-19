package payment;

public class WithdrawEarnings {
	void withdraw(int amount, String accountNumber) {
		System.out.println("Transaction success.");
		System.out.println("From: Company\nTo: "+accountNumber);
	}
}
