package entities;

public class Account {
    private int number;
    private String holder;
    protected double balance;

    public Account(int number, String holder, double balance) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
    }

    public void withdraw(double value) {
        if(value <= balance) {
            balance -= value;
        }
    }

    public void deposit(double value) {
        balance += value;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Name: ").append(getHolder())
                .append("\nNumber: ").append(getNumber())
                .append("\nBalance: ").append(balance)
                .append("\n");

        return sb.toString();
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }
}
