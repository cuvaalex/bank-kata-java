package gov.dgsi.kata.bank;

public class Account {
    private final TransactionRepository repository;

    public Account(TransactionRepository repository) {
        this.repository = repository;
    }

    public int deposit(int amount) {
        return this.repository.depositAmount(amount);
    }

    public int withdraw(int amount) {
        throw new UnsupportedOperationException();
    }

    public void printStatement() {
        throw new UnsupportedOperationException();
    }
}
