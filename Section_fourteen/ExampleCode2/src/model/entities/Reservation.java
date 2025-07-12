package model.entities;

import model.exceptions.DomainException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Reservation {
    private int roomNumber;
    private LocalDate checkIn;
    private LocalDate checkOut;

    public Reservation() {}

    public Reservation(int roomNumber, LocalDate checkIn, LocalDate checkOut) throws DomainException {
        if(!checkOut.isAfter(checkIn)) {
            throw new DomainException("Check-out date must be after check-in date");
        }

        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public long duration() {
        return ChronoUnit.DAYS.between(checkIn, checkOut);
    }

    public void updateCheck(LocalDate newCheckIn, LocalDate newCheckOut) throws DomainException {
        LocalDate now = LocalDate.now();

        if(!newCheckIn.isAfter(now)){
            throw new DomainException("Reservation dates for update must be future dates");
        }

        if(!newCheckOut.isAfter(newCheckIn)) {
            throw new DomainException("Check-out date must be after check-in date");
        }

        this.checkIn = newCheckIn;
        this.checkOut = newCheckOut;
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
            .append(dateTimeFormatter.format(checkOut))
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

    public LocalDate getCheckOut() {
        return checkOut;
    }
}
