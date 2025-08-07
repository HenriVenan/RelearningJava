package entities;

public class Country implements Comparable<Country> {
    private String name;
    private double amountInhabitants;

    public Country(String name, double amountInhabitants) {
        this.name = name;
        this.amountInhabitants = amountInhabitants;
    }

    @Override
    public int compareTo(Country otherCountry) {
        if (amountInhabitants > otherCountry.amountInhabitants) {
            return 1;
        }

        if (amountInhabitants < otherCountry.getAmountInhabitants()) {
            return -1;
        }

        return 0;
    }

    @Override
    public String toString() {
        return "   - " + name + " with " + amountInhabitants + " milions of inhabitants";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmountInhabitants() {
        return amountInhabitants;
    }

    public void setAmountInhabitants(double amountInhabitants) {
        this.amountInhabitants = amountInhabitants;
    }
}
