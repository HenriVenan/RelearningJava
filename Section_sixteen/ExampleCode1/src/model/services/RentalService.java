package model.services;

import exceptions.DataException;
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

    public void processInvoice(CarRental carRental) throws DataException {
        double hours = ((double) ChronoUnit.MINUTES.between(carRental.getStart(), carRental.getFinish())) / 60;

        if(hours != Math.floor(hours)) {
            hours = Math.floor(hours + 1);
        }

        double basicPayment;

        if (hours <= 24) {
            basicPayment = hours * pricePerHour;
        }

        else {
            basicPayment = Math.floor(1 + (hours / 24)) * pricePerDay;
        }

        carRental.setInvoice(new Invoice(basicPayment, serviceTax.tax(basicPayment)));
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
