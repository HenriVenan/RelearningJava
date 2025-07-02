package entities;

public class OutsourcedEmployee extends Employee {
    private double additionalCharge;

    public OutsourcedEmployee(
            String name,
            int hours,
            double valuePerHours,
            double additionalCharge
    ) {
        super(name, hours, valuePerHours);
        this.additionalCharge = additionalCharge;
    }

    @Override
    public double payment() {
        return (hours * valuePerHour) + (additionalCharge * 1.10);
    }

    public double getAdditionalCharge() {
        return additionalCharge;
    }

    public void setAdditionalCharge(double additionalCharge) {
        this.additionalCharge = additionalCharge;
    }
}
