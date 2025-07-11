package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import static java.lang.System.out;

public class Reservation {
    private int roomNumber;
    private LocalDate checkIn;
    private LocalDate checkOut;

    public Reservation() {}

    public Reservation(int roomNumber, LocalDate checkIn, LocalDate checkOut) {
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public long duration() {
        return ChronoUnit.DAYS.between(checkIn, checkOut);
    }

    public String updateCheck(LocalDate newCheckIn, LocalDate newCheckOut) {
        LocalDate now = LocalDate.now();

        if(newCheckIn.isAfter(now) && newCheckOut.isAfter(newCheckIn)){
            this.checkIn = newCheckIn;
            this.checkOut = newCheckOut;
            return null;
        }

        return "Reservation dates for update must be future dates";
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
