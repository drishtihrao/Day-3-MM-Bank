package com.cg.mmbank.account;
/*
 * This class is used to create a new account for the user
 * Next Account number calculation is defined in this method
 * The methods like withdraw and deposit is also defined in this class
 */
import com.cg.mmbank.paymentgateway.PaymentGateway;

public class Account {
	private int accountNumber = 0;
	private String name;
	private double Balance;
	private static int lastAccountNumber = 0;

	public Account(String name, double intialBalance) {
		this.name = name;
		this.Balance = intialBalance;
		accountNumber = lastAccountNumber + 1;
		lastAccountNumber = accountNumber;
	}

	public Account(String name) {
		this.name = name;
		accountNumber = lastAccountNumber + 1;
		lastAccountNumber = accountNumber;
	}

	public double getBalance() {
		return Balance;
	}

	//the user cannot withdraw a amount greater than his account balance
	public void withdraw(double amount) {
		if (this.Balance >= amount && amount > 0)
			this.Balance = this.Balance - amount;
		else
			System.out.println("Not enough balance");
	}

	public void deposit(double amount) {
		if (amount > 0)
			this.Balance = this.Balance + amount;
	}

	public static int getNextAccountNumber() {
		return lastAccountNumber + 1;
	}

	//in transaction, the balance of the person paying is checked
	//the entire amount gets deposited in the reciever's account
	public String transaction(Account reciever, double amount) {
		String result = new String();
		if (PaymentGateway.transfer(this, reciever, amount)) {
			result = "Payment was Successful";
		} else {
			result = "Payment Failed";
		}
		return result;
	}

	@Override
	public String toString() {
		return "Account id = " + accountNumber + ", holder's name =" + name + ", current balance =" + Balance + ".";
	}

}