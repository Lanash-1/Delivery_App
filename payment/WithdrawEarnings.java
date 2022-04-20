package payment;

public class WithdrawEarnings {
	public void withdraw(int amount, String accountNumber) {
		System.out.println("Transaction success.");
		System.out.println("From: Company\nTo: "+accountNumber);
	}
}
