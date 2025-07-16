package model.services;

import model.entities.CarRental;
import model.entities.Invoice;

import java.time.temporal.ChronoUnit;

public class RentalService {
    private Double pricePerHour;
    private Double pricePerDay;
    private final BrazilTaxService serviceTax = new BrazilTaxService();

    public RentalService(Double pricePerHour, Double pricePerDay) {
        this.pricePerHour = pricePerHour;
        this.pricePerDay = pricePerDay;
    }

    public void processInvoice(CarRental carRental) {
        double minutes = ChronoUnit.MINUTES.between(carRental.getStart(), carRental.getFinish());
        double hours = minutes / 60;

        if(hours != Math.floor(hours)) {
            hours = Math.floor(hours + 1);
        }

        if (hours <= 24) {
            double basicPayment = hours * pricePerHour;
            carRental.setInvoice(new Invoice(basicPayment, serviceTax.tax(basicPayment)));
        }

        if (hours > 24) {
            double basicPayment = Math.floor(1 + (hours / 24)) * pricePerDay;
            carRental.setInvoice(new Invoice(basicPayment, serviceTax.tax(basicPayment)));
        }
    }

    public Double getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(Double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public Double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(Double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }
}
