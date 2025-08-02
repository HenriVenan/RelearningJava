package application;

import entities.Product;
import services.CalculationService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        out.print("How many products will be added?: ");
        int amountProducts = sc.nextInt();
        List<Product> products = new ArrayList<>();

        for (int i = 0; i < amountProducts; i++) {
            out.printf("Product %dº: ", (i + 1));
            String productAndPriceString = sc.next();
            String[] productAndPrice = productAndPriceString.split(",");
            products.add(new Product(productAndPrice[0], Double.parseDouble(productAndPrice[1])));
        }

        out.println("\nMost expensive: ");
        out.println(CalculationService.max(products));
    }
}