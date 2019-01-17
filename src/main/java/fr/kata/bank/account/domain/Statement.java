package fr.kata.bank.account.domain;

import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;

public class Statement {

	public static final String STATEMENT_HEADER = "date  	       		     "
			+ "| credit | debit  | balance";

	final private List<StatementLine> statementLines = new LinkedList<StatementLine>();
	
	public void addLineContaining(Transaction transaction, Amount currentBalance) {
		statementLines.add( new StatementLine(transaction, currentBalance));
	}

	public void printTo(PrintStream printer) {
		printer.println(STATEMENT_HEADER);
		statementLines.stream().forEach(statementLine -> {
			statementLine.printTo(printer);
		});	
	}

}
