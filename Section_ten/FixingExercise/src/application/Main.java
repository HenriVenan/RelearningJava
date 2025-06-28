package application;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static java.lang.System.out;


public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        out.println("Enter the client data");
        out.print("Name: ");
        String name = sc.next();
        sc.next();

        out.print("Email: ");
        String email = sc.next();

        out.print("Birth Date (DD/MM/YYYY): ");
        CharSequence birthDate = sc.next();

        out.println("\nEnter order data: ");
        out.print("Status: ");
        OrderStatus orderStatus = OrderStatus.valueOf(sc.next());

        Client client = new Client(name, email, LocalDate.parse(birthDate, dtf));
        Order order = new Order(LocalDateTime.now(), orderStatus, client);

        out.print("How many items to this order?: ");
        int itemsQuantity = sc.nextInt();

        for(int i = 0; i < itemsQuantity; i++) {
            out.println("\nEnter #" + (i + 1) + " item data:");
            out.print("Product name: ");
            String item = sc.next();

            out.print("Product price: ");
            double price = sc.nextDouble();

            out.print("Product quantity: ");
            int quantity = sc.nextInt();

            order.addItem(new OrderItem(quantity, new Product(item, price)));
        }

        out.println(order);
        sc.close();
    }
}