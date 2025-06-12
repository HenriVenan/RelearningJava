import entities.Product;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Product product;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter product data: ");

        System.out.print("Name: ");
        String name = sc.next();

        System.out.print("Price: ");
        double price = sc.nextDouble();

        System.out.print("Quantity: ");
        int quantity = sc.nextInt();

        product = new Product(name, price, quantity);
        System.out.println("\nProduct data: " + product);

        System.out.print("\nEnter the number to be added in stock: ");
        product.addProducts(sc.nextInt());

        System.out.println("\nUpdated data: " + product);

        System.out.print("\nEnter the number to be removed in stock: ");
        product.removeProducts(sc.nextInt());

        System.out.println("\nUpdated data: " + product);

        sc.close();
    }
}