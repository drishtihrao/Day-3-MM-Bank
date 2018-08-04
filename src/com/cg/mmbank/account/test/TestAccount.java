package com.cg.mmbank.account.test;
/*
 * This class implements the methods defined in Payment Gateway and Account classes
 * The user can ask for the next account number before creating an account
 * The functions like withdraw and deposit are tested in this class
 */
import java.util.Scanner;
import com.cg.mmbank.account.Account;

public class TestAccount {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Account drishti = new Account("Drishti", 10000);
		System.out.println(drishti);

		int next = Account.getNextAccountNumber();
		System.out.println("The next acc no will be: " + next);

		System.out.println("Enter new account holder's name");
		Account name = new Account(scanner.next());
		System.out.println(name);

		next = Account.getNextAccountNumber();
		System.out.println("The next acc no will be: " + next);

		String result = drishti.transaction(name, 200);
		System.out.println(result);

		result = drishti.transaction(name, drishti.getBalance());
		System.out.println(result);

		System.out.println(drishti);
		System.out.println(name);

		drishti.withdraw(2000);
		System.out.println(drishti);

		drishti.deposit(20000);
		System.out.println(drishti);
	}

}