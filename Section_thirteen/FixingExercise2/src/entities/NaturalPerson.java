package entities;

public class NaturalPerson extends Person{
    private double healthSpending;

    public NaturalPerson(String name, double annualIncome, double healthSpending) {
        super(name, annualIncome);
        this.healthSpending = healthSpending;
    }

    @Override
    public double calcTax() {
        if (annualIncome < 20000) {
            return (annualIncome * 0.15) - (healthSpending * 0.5);
        }

        return (annualIncome * 0.25) - (healthSpending * 0.5);
    }

    public double getHealthSpending() {
        return healthSpending;
    }

    public void setHealthSpending(double healthSpending) {
        this.healthSpending = healthSpending;
    }
}
