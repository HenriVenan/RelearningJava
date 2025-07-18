package entities;

public class Product {
    protected String name;
    protected double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String priceTag() {
        StringBuilder stringB = new StringBuilder();

        stringB.append(name)
                .append(" - $ ")
                .append(String.format("%.2f", price));

        return stringB.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }
}
