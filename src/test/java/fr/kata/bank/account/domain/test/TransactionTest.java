package fr.kata.bank.account.domain.test;

import static fr.kata.bank.account.domain.Amount.amountOf;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.io.PrintStream;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import fr.kata.bank.account.domain.Amount;
import fr.kata.bank.account.domain.Transaction;


@RunWith(MockitoJUnitRunner.class)
public class TransactionTest {
PrintStream printer;
	
	
	@Test public void
	should_calculate_current_balance_after_deposit() {
		Transaction transaction = new Transaction(amountOf(1000), new Date("10/01/2012"));
		
		Amount currentValue = transaction.balanceAfterTransaction(amountOf(100));
		
		assertThat(currentValue, is(amountOf(1100)));
	}

	@Test public void
	should_calculate_current_balance_after_withdrawal() {
		Transaction transaction = new Transaction(amountOf(-1000), new Date("10/01/2012"));
		
		Amount currentValue = transaction.balanceAfterTransaction(amountOf(100));
		
		assertThat(currentValue, is(amountOf(-900)));
	}
	
	@Test public void
	should_be_equal_to_other_transaction_with_same_value_and_date() {
		Date depositDate = new Date("10/01/2012");
		Transaction depositOfOneHundred = new Transaction(amountOf(1000), depositDate);
		Transaction anotherDepositOfOneHundred = new Transaction(amountOf(1000), depositDate);
		
		assertEquals(depositOfOneHundred, anotherDepositOfOneHundred);
	}
}
