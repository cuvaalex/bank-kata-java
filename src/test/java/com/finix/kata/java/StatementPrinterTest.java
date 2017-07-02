package com.finix.kata.java;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static java.util.Collections.EMPTY_LIST;
import static org.mockito.Mockito.verify;

/**
 * Created by alex on 7/2/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class StatementPrinterTest {
    public static final List<Transaction> NO_TRANSACTION = EMPTY_LIST;
    private StatementPrinter statement;

    @Mock Console console;

    @Before
    public void setUp() {
        statement = new StatementPrinter(console);
    }

    @Test 
        public void should_always_print_header() {

        statement.print(NO_TRANSACTION);

        verify(console).printline("date       || credit   || debit    || balance");
    }
    
    @Test 
        public void should_always_print_statement_reverse_mode() {

        List<Transaction> transactions = transactionContaining(
          depositTransaction("10/01.2012", 1000.00),
            depositTransaction("13/01.2012", 1000.00),
            widthrawtransaction("14/01.2012", 500.00)
        );

        statement.print(transactions);

        InOrder inOrder = Mockito.inOrder(console);

        inOrder.verify(console).printline("date       || credit   || debit    || balance");
        inOrder.verify(console).printline("14/01/2012 ||          || 500.00   || 2500.00");
        inOrder.verify(console).printline("13/01/2012 || 2000.00  ||          || 3000.00");
        inOrder.verify(console).printline("10/01/2012 || 1000.00  ||          || 1000.00");

    }

    private List<Transaction> transactionContaining(Transaction... transactions) {
        return Arrays.asList(transactions);
    }

    private Transaction widthrawtransaction(String date, double amount) {
        return new Transaction(date, -amount);
    }

    private Transaction depositTransaction(String date, double amount){
        return new Transaction(date, amount);
    }
}