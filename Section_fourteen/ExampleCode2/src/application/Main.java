package application;

import model.entities.Reservation;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Reservation reservation = new Reservation();

        out.print("Room number: ");
        int roomNumber = sc.nextInt();

        out.print("Check-in date (dd/MM/yyyy): ");
        LocalDate checkIn = LocalDate.parse(sc.next(), dateFormatter);


        out.print("Check-out date (dd/MM/yyyy): ");
        LocalDate checkOut = LocalDate.parse(sc.next(), dateFormatter);

        if(checkOut.isAfter(checkIn)) {
            reservation = new Reservation(roomNumber, checkIn, checkOut);
            out.println(reservation);
        }

        else {
            out.println("Error in reservation: Check-out must be after Check-in date");
            System.exit(0);
        }


        out.println("\nEnter data to update the reservation: ");
        out.print("Check-in date (dd/MM/yyyy): ");
        LocalDate updateCheckIn = LocalDate.parse(sc.next(), dateFormatter);


        out.print("Check-out date (dd/MM/yyyy): ");
        LocalDate updateCheckOut = LocalDate.parse(sc.next(), dateFormatter);

        String error = reservation.updateCheck(updateCheckIn, updateCheckOut);

        if(error == null) {
            out.println(reservation);
        }

        else {
            out.println("Error reservation: " + error);
        }
    }
}