package com.finix.kata.java;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

/**
 * Created by alex on 6/20/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class TransactionRepositoryShould {
    public static final String TODAY = "12/05/2017";
    private TransactionRepository transactionRepository;
    @Mock Clock clock;

    @Before
        public void setUp() {
            transactionRepository = new TransactionRepository(clock);
    }

    @Test public void create_and_store_deposit_transaction() {
        given(clock.todayAsString()).willReturn(TODAY);
        transactionRepository.addDeposit(100);

        List<Transaction> transactions = transactionRepository.allTransactions();

        assertThat(transactions.size(), is(1));
        assertThat(transactions.get(0), is(transaction(TODAY, 100)));
    }
    
    @Test 
        public void create_and_store_withdraw_transaction() {
        given(clock.todayAsString()).willReturn(TODAY);
        transactionRepository.addWithdraw(100);

        List<Transaction> transactions = transactionRepository.allTransactions();

        assertThat(transactions.size(), is(1));
        assertThat(transactions.get(0), is(transaction(TODAY, -100)));
    }

    private Transaction transaction(String date, double amount) {
        return new Transaction(date, amount);
    }
}