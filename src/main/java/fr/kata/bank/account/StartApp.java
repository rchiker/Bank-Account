package fr.kata.bank.account;

import java.util.Date;

import fr.kata.bank.account.application.Account;
import fr.kata.bank.account.application.AccountImpl;
import fr.kata.bank.account.domain.Statement;

import static fr.kata.bank.account.domain.Amount.amountOf;

public class StartApp {
	
	public static void main(String[] args) {
		Statement statement = new Statement();
		AccountImpl account = new AccountImpl(statement);
		
		account.deposit(amountOf(100), new Date("17/01/2019"));
		account.deposit(amountOf(100), new Date("16/01/2019"));
		account.withdrawal(amountOf(150), new Date("14/01/2019"));
		
		account.printHistory(System.out);
	}

}
