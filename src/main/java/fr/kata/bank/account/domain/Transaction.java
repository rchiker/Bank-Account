package fr.kata.bank.account.domain;

import java.util.Date;

public class Transaction {

	private Amount value;
	private Date date;

	public Transaction(Amount value, Date date) {
		this.value = value;
		this.date = date;
	}
}
