package fr.kata.bank.account.domain;

import static fr.kata.bank.account.domain.Amount.amountOf;

import java.io.PrintStream;
import java.util.Date;

public class Transaction {

	private Amount value;
	private Date date;

	private static final String EMPTY_VALUE = "        ";

	public Transaction(Amount value, Date date) {
		this.value = value;
		this.date = date;
	}

	public Amount balanceAfterTransaction(Amount currentBalance) {
		return currentBalance.plus(value);
	}

	public void printTo(PrintStream printer, Amount currentBalance) {
		StringBuilder builder = new StringBuilder();
		addDateTo(builder);
		addValueTo(builder);
		addCurrentBalanceTo(builder, currentBalance);
		printer.println(builder.toString());
	}

	private void addCurrentBalanceTo(StringBuilder builder, Amount currentBalance) {
		builder.append("|  ")
		.append(currentBalance.getValue());
	}

	private void addValueTo(StringBuilder builder) {
		if (value.isGreaterThan(amountOf(0))) {
			addCreditTo(builder);
		} else {
			addDebitTo(builder);
		}
	}

	private void addDebitTo(StringBuilder builder) {
		builder.append(EMPTY_VALUE)
		.append("|")
		.append(valueToString())
		.append("    ");
	}

	private void addCreditTo(StringBuilder builder) {
		builder.append(valueToString())
		.append("    |")
		.append(EMPTY_VALUE);
	}

	private String valueToString() {
		String stringValue = " " + value.absoluteValue().getValue();
		return stringValue;
	}

	private void addDateTo(StringBuilder builder) {
		builder.append(date);
		builder.append(" |");
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
