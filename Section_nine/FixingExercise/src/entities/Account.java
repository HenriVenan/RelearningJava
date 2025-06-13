package entities;

public class Account {
    private String name;
    private int number;
    private double balance = 0;

    public Account(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public void deposit(double value) {
        this.balance += value;
    }

    public void withdraw(double value) {
        this.balance -= value + 5;
    }

    public double getNumber() {
        return number;
    }

    public String toString() {
        return
            "Account " + number +
            ", Holder: " + name +
            ", Balance: $ " + balance;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

}
