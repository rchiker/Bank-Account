package fr.kata.bank.account;

import fr.kata.bank.account.application.Account;
import fr.kata.bank.account.application.AccountImpl;

public class StartApp {
	
	public static void main(String[] args) {
		AccountImpl account = new AccountImpl();
		
		account.deposit(1000, "10/01/2012");
		account.deposit(2000, "13/01/2012");
		account.withdrawal(500, "14/01/2012");
		
		account.printHistory(System.out);
	}

}
