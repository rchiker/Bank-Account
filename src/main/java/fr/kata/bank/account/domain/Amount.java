package fr.kata.bank.account.domain;

public class Amount {

	private int value;

	public Amount(int value) {
		this.value = value;
	}

	public static Amount amountOf(int value) {
		return new Amount(value);
	}

	public Amount plus(Amount otherAmount) {
		return amountOf(this.value + otherAmount.value);
	}

	public boolean isGreaterThan(Amount otherAmount) {
		return this.value > otherAmount.value;
	}

	public Amount absoluteValue() {
		return amountOf(Math.abs(value));
	}

	public Amount negative() {
		return amountOf(-value);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + value;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		Amount other = (Amount) obj;
		if (value != other.value)
			return false;
		return true;
	}

}
