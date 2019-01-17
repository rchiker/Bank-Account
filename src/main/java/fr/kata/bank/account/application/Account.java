package fr.kata.bank.account.application;

import java.io.PrintStream;
import java.util.Date;

import fr.kata.bank.account.domain.Amount;

public interface Account {

	public void deposit(Amount value, Date date);

	public void withdrawal(Amount value, Date date);

	public void printHistory(PrintStream printer);
	
}
