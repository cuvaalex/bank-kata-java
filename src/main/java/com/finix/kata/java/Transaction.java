package com.finix.kata.java;

/**
 * Created by alex on 6/20/17.
 */
public class Transaction {



    private final String date;

    private final int amount;

    public Transaction(String date, int amount) {
        this.date = date;
        this.amount = amount;
    }

    public String date() {
        return date;
    }
    public int amount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transaction that = (Transaction) o;

        return Integer.compare(that.amount, amount) == 0
                && (date != null ? date.equals(that.date) : that.date == null);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = date != null ? date.hashCode() : 0;
        temp = amount;
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
