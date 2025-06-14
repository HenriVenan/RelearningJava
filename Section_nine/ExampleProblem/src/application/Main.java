package application;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("How much persons heights will be added?: ");
        int personsQuantity = sc.nextInt();
        double[] heights = new double[personsQuantity];

        System.out.println();

        for(int i = 0; i < personsQuantity; i++) {
            System.out.printf("Height of person %dº: ", (i + 1));
            heights[i] = sc.nextDouble();
        }

        double averageHeight = 0;

        for(int i = 0; i < personsQuantity; i++) {
            averageHeight += heights[i];
        }

        System.out.println("\nAverage Height: " + String.format("%.2f", (averageHeight / personsQuantity)));
    }
}