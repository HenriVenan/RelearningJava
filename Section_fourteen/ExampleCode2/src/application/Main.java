package application;

import model.entities.Reservation;
import model.exceptions.DomainException;

import java.text.ParseException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Reservation reservation = new Reservation();

        try {
            out.print("Room number: ");
            int roomNumber = sc.nextInt();

            out.print("Check-in date (dd/MM/yyyy): ");
            LocalDate checkIn = LocalDate.parse(sc.next(), dateFormatter);


            out.print("Check-out date (dd/MM/yyyy): ");
            LocalDate checkOut = LocalDate.parse(sc.next(), dateFormatter);

            reservation = new Reservation(roomNumber, checkIn, checkOut);
            out.println(reservation);

            out.println("\nEnter data to update the reservation: ");
            out.print("Check-in date (dd/MM/yyyy): ");
            LocalDate updateCheckIn = LocalDate.parse(sc.next(), dateFormatter);


            out.print("Check-out date (dd/MM/yyyy): ");
            LocalDate updateCheckOut = LocalDate.parse(sc.next(), dateFormatter);

            reservation.updateCheck(updateCheckIn, updateCheckOut);
            out.println(reservation);
        }

        catch (InputMismatchException err) {
            out.println("Error in reservation: Enter valid room number!");
        }

        catch (DateTimeParseException err) {
            out.println("Error in reservation: Enter valid date");
        }

        catch (DomainException err) {
            out.println("Error in reservation: " + err.getMessage());
        }
    }
}