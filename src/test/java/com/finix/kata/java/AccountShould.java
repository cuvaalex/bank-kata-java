package com.finix.kata.java;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static java.util.Arrays.asList;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

/**
 * Created by alex on 6/14/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class AccountShould
{
    private Account account;

    @Mock TransactionRepository transactionRepository;
    @Mock StatementPrinter statementPrinter;

    @Before
        public void setUp() {
            account = new Account(transactionRepository, statementPrinter);
    }

    @Test
        public void should_store_deposit_transaction() {
            account.deposit(100);

            verify(transactionRepository).addDeposit(100);
    }
    
    @Test 
        public void should_store_withdraw_transaction() {
            account.withdraw(100);

            verify(transactionRepository).addWithdraw(100);

    }
    
    @Test 
        public void should_print_statement() {
        List<Transaction> transactions = asList(new Transaction("10/12/2015", 100));
        given(transactionRepository.allTransactions()).willReturn(transactions);

        account.printStatement();

        verify(statementPrinter).print(transactions);
    }
}