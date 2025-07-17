package model.services;

import exceptions.DataException;
import model.entities.CarRental;
import model.entities.Invoice;
import model.services.interfaces.TaxService;

import java.time.Duration;

public class RentalService {
    private Double pricePerHour;
    private Double pricePerDay;
    private final TaxService serviceTax;

    public RentalService(Double pricePerHour, Double pricePerDay, TaxService serviceTax) {
        this.pricePerHour = pricePerHour;
        this.pricePerDay = pricePerDay;
        this.serviceTax = serviceTax;
    }

    public void processInvoice(CarRental carRental) throws DataException {
        double minutes = Duration.between(carRental.getStart(), carRental.getFinish()).toMinutes();
        double hours = minutes / 60;

        double basicPayment;

        if (hours <= 12) {
            basicPayment = Math.ceil(hours) * pricePerHour;
        }

        else {
            basicPayment = Math.ceil(hours / 24) * pricePerDay;
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
