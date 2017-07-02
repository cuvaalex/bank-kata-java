package features;

import com.finix.kata.java.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

/**
 * Created by alex on 6/14/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class PrintStatementFeature {

    private Account account;

    @Mock
    Console console;
    @Mock
    Clock clock;

    @Before
    public void setUp() {
        TransactionRepository transactionRepository = new TransactionRepository(clock);
        StatementPrinter statementPrinter = new StatementPrinter(console);
        account = new Account(transactionRepository, statementPrinter);
    }

    @Test
    public void
    should_print_full_statement() {
        account.deposit(1000.00);
        account.deposit(2000.00);
        account.withdraw(500.00);

        account.printStatement();

        InOrder inOrder = Mockito.inOrder(console);

        inOrder.verify(console).printline("date       || credit   || debit    || balance");
        inOrder.verify(console).printline("14/01/2012 ||          || 500.00   || 2500.00");
        inOrder.verify(console).printline("13/01/2012 || 2000.00  ||          || 3000.00");
        inOrder.verify(console).printline("10/01/2012 || 1000.00  ||          || 1000.00");
    }
}
