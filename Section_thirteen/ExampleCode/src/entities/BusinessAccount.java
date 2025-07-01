package entities;

public class BusinessAccount extends Account {
    private final Double loanLimit;

    public BusinessAccount(double loanLimit, int number, String holder, double balance) {
        super(number, holder, balance);
        this.loanLimit = loanLimit;
    }

    public void loan(double amount) {
        if(amount <= loanLimit) {
            balance += amount - 10;
        }
    }

    public double getLoanLimit() {
        return loanLimit;
    }
}
