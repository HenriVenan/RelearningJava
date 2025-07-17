package application;

import exceptions.DataException;
import model.entities.CarRental;
import model.entities.Vehicle;
import model.services.BrazilTaxService;
import model.services.RentalService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CarRental carRental;
        double valuePerHour, valuePerDay;

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy-HH:mm");

        try {
            out.println("Entre com os dados do aluguel de carro: ");
            out.print("Modelo do Carro: ");
            String carModel = sc.next();

            out.print("Retirada (dd/MM/yyyy hh:mm): ");
            LocalDateTime start = LocalDateTime.parse(sc.next(), fmt);

            out.print("Retorno (dd/MM/yyyy hh:mm): ");
            LocalDateTime finish = LocalDateTime.parse(sc.next(), fmt);

            out.print("Entre com o preço por hora: ");
            valuePerHour = sc.nextDouble();

            out.print("Entre com o preço por dia: ");
            valuePerDay = sc.nextDouble();

            carRental = new CarRental(start, finish, new Vehicle(carModel));

            RentalService rentalService = new RentalService(valuePerHour, valuePerDay, new BrazilTaxService());
            rentalService.processInvoice(carRental);

            out.println("\nFATURA: ");
            out.print(carRental);
        }

        catch (DateTimeParseException err) {
            out.println("Error: Insira as datas corretamente");
        }

        catch (InputMismatchException err) {
            out.println("Error: Insira os preços corretamente");
        }

        catch (DataException err) {
            out.println(err.getMessage());
        }

    }
}