package entities;

public class SavingsAccount extends Account{
    private final double interestRate;

    public SavingsAccount(int number, String holder, double balance, Double interestRate) {
        super(number, holder, balance);
        this.interestRate = interestRate;
    }

    public void updateBalance() {
        balance += balance * (interestRate / 100);
    }

    @Override
    public void withdraw(double value) {
        if(value <= balance) {
            balance -= value;
        }
    }

    public Double getInterestRate() {
        return interestRate;
    }
}
