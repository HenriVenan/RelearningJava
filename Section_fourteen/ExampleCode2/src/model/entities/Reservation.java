package model.entities;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Reservation {
    private int roomNumber;
    private LocalDate checkIn;
    private LocalDate checkout;

    public Reservation() {}

    public Reservation(int roomNumber, LocalDate checkIn, LocalDate checkout) {
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkout = checkout;
    }

    public long duration() {
        return ChronoUnit.DAYS.between(checkIn, checkout);
    }

    public void updateCheck(LocalDate checking, LocalDate checkout) {
        this.checkIn = checking;
        this.checkout = checkout;
    }

    @Override
    public String toString() {
        StringBuilder strB = new StringBuilder();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        strB
                .append("Reservation: Room ")
                .append(roomNumber)
                .append(", check-in: ")
                .append(dateTimeFormatter.format(checkIn))
                .append(", check-out: ")
                .append(dateTimeFormatter.format(checkout))
                .append(", ")
                .append(duration())
                .append(" nigths");

        return strB.toString();
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public LocalDate getCheckin() {
        return checkIn;
    }

    public LocalDate getCheckout() {
        return checkout;
    }
}
