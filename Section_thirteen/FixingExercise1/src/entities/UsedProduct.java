package entities;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class UsedProduct extends Product{
    private final LocalDate manufactureDate;

    public UsedProduct(String name, double price, LocalDate manufactureDate) {
        super(name, price);
        this.manufactureDate = manufactureDate;
    }

    @Override
    public String priceTag() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        StringBuilder stringB = new StringBuilder();

        stringB.append(name)
                .append(" (Used)")
                .append(" $ ")
                .append(String.format("%.2f", price))
                .append(" (")
                .append(dtf.format(manufactureDate))
                .append(")");

        return stringB.toString();
    }

    public LocalDate getManufactureDate() {
        return manufactureDate;
    }
}
