package fr.kata.bank.account.application;

import static fr.kata.bank.account.domain.Amount.amountOf;

import java.io.PrintStream;
import java.util.Date;

import fr.kata.bank.account.domain.Amount;
import fr.kata.bank.account.domain.Statement;
import fr.kata.bank.account.domain.Transaction;

public class AccountImpl implements Account {
	
	private Statement statement;
	private Amount solde = amountOf(0);
	
	public AccountImpl(Statement statement){
		super();
		this.statement = statement ;
	}

	public void deposit(final Amount value, final Date date) {
		recordTransaction(value, date);
	}

	public void withdrawal(final Amount value, final Date date) {
		recordTransaction(value.negative(), date);
		
	}

	public void printHistory(final PrintStream printer) {
		statement.printTo(printer);
		
	}
	
	private void recordTransaction(final Amount value, final Date date) {
		Transaction transaction = new Transaction(value, date);
		Amount soldeAfterTransaction = transaction.balanceAfterTransaction(solde);
		solde = soldeAfterTransaction;
		statement.addLineContaining(transaction, soldeAfterTransaction);
	}

	
}
