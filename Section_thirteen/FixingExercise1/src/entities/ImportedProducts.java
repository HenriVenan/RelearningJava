package entities;

public class ImportedProducts extends Product {
    private final double customFee;

    public ImportedProducts(String name, double price, double customFee) {
        super(name, price);
        this.customFee = customFee;
    }

    @Override
    public String priceTag() {
        StringBuilder stringB = new StringBuilder();

        stringB.append(name)
                .append(" - $ ")
                .append(String.format("%.2f", totalPrice()))
                .append(" (Custom fee: $ ")
                .append(String.format("%.2f", customFee))
                .append(")");

        return stringB.toString();
    }

    public double totalPrice() {
        return price + customFee;
    }

    public double getCustomFee() {
        return customFee;
    }
}
