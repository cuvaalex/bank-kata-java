package gov.dgsi.kata.bank.feature;

import gov.dgsi.kata.bank.Account;
import gov.dgsi.kata.bank.Console;
import gov.dgsi.kata.bank.TransactionRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


/**
 * Created by alex on 6/14/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class PrintStatementFeature {

    private Account account;

    @Mock
    TransactionRepository repository;

    @Mock
    Console console;

    @Before
    public void setUp() {
        account = new Account(repository);
    }

    @Test
    public void
    should_print_full_statement() {

        account.deposit(1000);
        account.deposit(2000);
        account.withdraw(500);

        account.printStatement();

        InOrder inOrder = Mockito.inOrder(console);

        inOrder.verify(console).printline("date       || credit   || debit    || balance");
        inOrder.verify(console).printline("14/01/2012 || 0 || 500 || 2500");
        inOrder.verify(console).printline("13/01/2012 || 2000 || 0 || 3000");
        inOrder.verify(console).printline("10/01/2012 || 1000 || 0 || 1000");
    }
}