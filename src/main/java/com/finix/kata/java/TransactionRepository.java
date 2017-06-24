package com.finix.kata.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.unmodifiableList;

/**
 * Created by alex on 6/15/17.
 */
public class TransactionRepository {

    private final Clock clock;
    private List<Transaction> transactions = new ArrayList<Transaction>();

    public TransactionRepository(Clock clock) {
        this.clock = clock;
    }

    public List<Transaction> allTransactions() {
        return unmodifiableList(transactions);
    }

    public void addDeposit(double amount) {
        transactions.add(new Transaction(this.clock.todayAsString(), amount));
    }

    public void addWithdraw(double amount) {
        transactions.add(new Transaction(clock.todayAsString(), -amount));
    }
}
