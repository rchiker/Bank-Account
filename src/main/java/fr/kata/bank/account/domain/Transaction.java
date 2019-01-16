package fr.kata.bank.account.domain;

import java.util.Date;

public class Transaction {

	private Amount value;
	private Date date;

	public Transaction(Amount value, Date date) {
		this.value = value;
		this.date = date;
	}
	
	public Amount balanceAfterTransaction(Amount currentBalance) {
		return currentBalance.plus(value);
	}
	
	@Override
	public boolean equals(Object obj) {
		Transaction other = (Transaction) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
}
