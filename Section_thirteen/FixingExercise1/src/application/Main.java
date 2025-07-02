package application;

import entities.ImportedProducts;
import entities.Product;
import entities.UsedProduct;
import tests.MainTest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {
        MainTest.simulator("3",
                "i", "Tablet", "260", "20",
                "c", "Notebook", "1100",
                "u", "Iphone", "400", "15/03/2017"
        );

        Scanner sc = new Scanner(System.in);

        out.print("Enter the number of products: ");
        int numberOfProducts = sc.nextInt();
        ArrayList<Product> products = new ArrayList<>();

        for (int i = 0; i < numberOfProducts; i++) {
            out.println("\nProduct " + (i + 1) + " data: ");
            out.print("Common, used or imported (c/u/i): ");
            char type = sc.next().charAt(0);

            if((type != 'c') && (type != 'u') && (type != 'i')) {
                out.println("\nDigite um valor válido!");
                System.exit(0);
            }

            out.print("Name: ");
            String name = sc.next();

            out.print("Price: ");
            double price = sc.nextDouble();

            switch (type) {
                case 'c':
                    products.add(new Product(name, price));
                break;

                case 'i':
                    out.print("Custom fee: ");
                    products.add(new ImportedProducts(name, price, sc.nextDouble()));
                break;

                case 'u':
                    out.print("Manufacture Date (DD/MM/YYYY): ");
                    products.add(new UsedProduct(name, price,
                            LocalDate.parse(
                                sc.next(),
                                DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
                break;
            }
        }

        out.println("\n\nPRICE TAGS: ");
        for (Product product : products) {
            out.print(product.priceTag() + "\n");
        }
    }
}