package fr.kata.bank.account.domain;

public class StatementLine {

	private Transaction transaction;
	private Amount currentBalance;

	public StatementLine(Transaction transaction, Amount currentBalance) {
		this.transaction = transaction;
		this.currentBalance = currentBalance;
	}


}
