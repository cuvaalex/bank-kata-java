package gov.dgsi.kata.bank;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AccountTest {

    @Mock
    TransactionRepository repository;


    @Test
    public void shouldDepositAmount () {
        Account account = new Account(repository);

        account.deposit(200);

        verify(repository).depositAmount(200);

    }
}
