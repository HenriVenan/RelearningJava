package application;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos números você vai digitar: ");
        int quantNumbers = sc.nextInt();
        double[] numbers = new double[quantNumbers];

        System.out.println();

        for(int i = 0; i < quantNumbers; i++) {
            System.out.printf("Digite 0 %dº número: ", (i + 1));
            numbers[i] = sc.nextDouble();
        }

        double sumNumbers = 0;

        System.out.print("\nValores: ");
        for(int i = 0; i < quantNumbers; i++) {
            System.out.printf("[%.2f] ", numbers[i]);
            sumNumbers += numbers[i];
        }

        System.out.printf("\nSoma: %.2f", sumNumbers);
        System.out.printf("\nMédia: %.2f", (sumNumbers / quantNumbers));

    }
}