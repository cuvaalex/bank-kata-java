package com.finix.kata.java;

import java.util.List;

/**
 * Created by alex on 6/20/17.
 */
public class StatementPrinter {
    public static final String STATEMENT_HEADER = "date       || credit   || debit    || balance";
    private final Console console;

    public StatementPrinter(Console console) {

        this.console = console;
    }

    public void print(List<Transaction> transactions) {
        console.printline(STATEMENT_HEADER);
    }
}
