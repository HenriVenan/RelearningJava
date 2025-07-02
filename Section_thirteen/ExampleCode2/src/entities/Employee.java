package entities;

public class Employee {
    private String name;
    protected int hours;
    protected double valuePerHour;

    public Employee(String name, int hours, double valuePerHour) {
        this.name = name;
        this.hours = hours;
        this.valuePerHour = valuePerHour;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(name)
            .append(" - $ ")
        .append(payment());

        return sb.toString();
    }

    public double payment() {
        return hours * valuePerHour;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public double getValuePerHour() {
        return valuePerHour;
    }

    public void setValuePerHour(double valuePerHour) {
        this.valuePerHour = valuePerHour;
    }
}
