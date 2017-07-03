package com.finix.kata.java;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * Created by alex on 6/20/17.
 */
public class StatementPrinter {
    public static final String STATEMENT_HEADER = "date       || credit   || debit    || balance";
    private final Console console;
    private AtomicInteger runningTotal = new AtomicInteger();

    public StatementPrinter(Console console) {

        this.console = console;
    }

    public void print(List<Transaction> transactions) {
        console.printline(STATEMENT_HEADER);

        transactions.stream().map((Transaction transaction) -> {
            return statementLine(transaction, runningTotal);
        }).collect(Collectors.toCollection(LinkedList::new))
                .descendingIterator()
                .forEachRemaining(console::printline);

    }

    private String statementLine(Transaction transaction, AtomicInteger runningTotal) {
        int credit = transaction.amount() < 0?0:transaction.amount();
        int debit = transaction.amount() < 0?-transaction.amount():0;
        return  transaction.date()
                + " || " + credit
                + " || " + debit
                + " || " + runningTotal.addAndGet(transaction.amount());
    }
}
