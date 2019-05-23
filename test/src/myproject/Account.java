package myproject;

public class Account {
	private int accountNumber;
	private double balance;
	
	public Account (int accountNumber, double balance) {
		this.balance = balance;
		this.accountNumber = accountNumber;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
	
}
