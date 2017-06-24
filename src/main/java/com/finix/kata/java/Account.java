package com.finix.kata.java;

import java.util.List;

/**
 * Created by alex on 6/14/17.
 */
public class Account {

    private TransactionRepository transactionRepository;
    private  StatementPrinter statementPrinter;

    public Account(TransactionRepository transactionRepository, StatementPrinter statementPrinter) {
        this.transactionRepository = transactionRepository;
        this.statementPrinter = statementPrinter;
    }

    public void deposit(double amount) {
        transactionRepository.addDeposit(amount);
    }

    public void withdraw(double amount) {
        transactionRepository.addWithdraw(amount);
    }

    public void printStatement() {
        List<Transaction> transactions = transactionRepository.allTransactions();

        this.statementPrinter.print(transactions);
    }
}
