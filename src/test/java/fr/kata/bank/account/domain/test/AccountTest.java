package fr.kata.bank.account.domain.test;

import static fr.kata.bank.account.domain.Amount.amountOf;
import static org.mockito.Mockito.verify;
import static fr.kata.bank.account.utils.TransactionBuilder.aTransaction;


import java.io.PrintStream;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import fr.kata.bank.account.application.Account;
import fr.kata.bank.account.application.AccountImpl;
import fr.kata.bank.account.domain.Amount;
import fr.kata.bank.account.domain.Statement;

@RunWith(MockitoJUnitRunner.class)
public class AccountTest {
	
	@Mock private Statement statement;
	private AccountImpl account;

	@Before
	public void initialise() {
		account = new AccountImpl(statement);
	}
	
	@Test public void
	should_add_deposit_line_to_statement() {
		Date depositDate = new Date("16/01/2019");
		Amount depositAmount = amountOf(1000);
		
		account.deposit(depositAmount, depositDate);
		
		verify(statement).addLineContaining(aTransaction()
												.with(depositDate)
												.with(depositAmount).build(),
											currentBalanceEqualsTo(depositAmount));
	}
	
	@Test public void
	should_add_withdraw_line_to_statement() {
		Date withdrawalDate = date("16/01/2019");
		
		account.withdrawal(amountOf(500), withdrawalDate);
		
		verify(statement).addLineContaining(aTransaction()
											.with(amountOf(-500))
											.with(withdrawalDate).build(), 
											amountOf(-500));
	}
	
	@Test public void
	should_print_statement() {
		PrintStream printer = System.out;
		
		account.printStatement(printer);
		
		verify(statement).printTo(printer);
	}
	
	private Amount currentBalanceEqualsTo(Amount amount) {
		return amount;
	}

}
