package application;

import entities.Product;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the quantity to be added: ");
        int quantityProduct = sc.nextInt();
        Product[] products = new Product[quantityProduct];

        for(int i = 0; i < quantityProduct; i++) {
            System.out.printf("\nName of product %dº: ", (i + 1));
            String name = sc.next();

            System.out.printf("Value of product %dº: ", (i + 1));
            double value = sc.nextDouble();

            products[i] = new Product(name, value);
        }

        double sumPrices = 0;

        for(int i = 0; i < quantityProduct; i++) {
            sumPrices += products[i].getPrice();
        }

        System.out.printf("\nAverage Price: %.2f", (sumPrices / quantityProduct));
    }
}