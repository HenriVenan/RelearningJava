package entities;

public class LegalEntity extends Person{
    private int amountEmployees;

    public LegalEntity(String name, double annualIncome, int amountEmployees) {
        super(name, annualIncome);
        this.amountEmployees = amountEmployees;
    }

    @Override
    public double calcTax() {
        if (amountEmployees < 10) {
            return (annualIncome * (16.00 / 100));
        }

        return (annualIncome * (14.00 / 100));
    }

    public int getAmountEmployees() {
        return amountEmployees;
    }

    public void setAmountEmployees(int amountEmployees) {
        this.amountEmployees = amountEmployees;
    }
}
