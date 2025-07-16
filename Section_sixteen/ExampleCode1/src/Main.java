
import model.entities.CarRental;
import model.entities.Vehicle;
import model.services.RentalService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
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

            Vehicle vehicle = new Vehicle(carModel);
            carRental = new CarRental(start, finish, vehicle);

            RentalService rentalService = new RentalService(valuePerHour, valuePerDay);
            rentalService.processInvoice(carRental);

            out.println("\nFATURA: ");
            out.print(carRental);
        }

        catch (Exception err) {
            out.println("Houve um erro: " + Arrays.toString(err.getStackTrace()));
            out.println("Mensagem: " + err.getMessage());
        }

    }
}