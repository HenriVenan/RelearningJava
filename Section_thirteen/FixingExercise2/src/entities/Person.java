package entities;

public abstract class Person {
    private String name;
    protected double annualIncome;

    public Person(String name, double annualIncome) {
        this.name = name;
        this.annualIncome = annualIncome;
    }

    public abstract double calcTax();

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb
                .append(name)
                .append(": $ ")
                .append(String.format("%.2f", calcTax()));

        return sb.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(double annualIncome) {
        this.annualIncome = annualIncome;
    }
}
