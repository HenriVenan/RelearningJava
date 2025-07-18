package model.entities;

import exceptions.DataException;

import java.time.LocalDateTime;

public class CarRental {
    private LocalDateTime start;
    private LocalDateTime finish;
    private Vehicle vehicle;
    private Invoice invoice;

    public CarRental(LocalDateTime start, LocalDateTime finish, Vehicle vehicle) throws DataException {
        if (finish.isBefore(start)) {
            throw new DataException("Data de retorno deve ser depois da data de entrega");
        }

        this.start = start;
        this.finish = finish;
        this.vehicle = vehicle;
    }

    public CarRental() {}

    public String toString() {
        StringBuilder stringB = new StringBuilder();

        stringB
                .append("Pagamento básico: ")
                .append(invoice.getBasicPayment())
                .append("\nImposto: ")
                .append(String.format("%.2f", invoice.getTax()))
                .append("\nPagamento total: ")
                .append(String.format("%.2f", invoice.totalPayment()));

        return stringB.toString();
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getFinish() {
        return finish;
    }

    public void setFinish(LocalDateTime finish) {
        this.finish = finish;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
}
