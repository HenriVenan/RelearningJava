package application;

import services.PrintService;

import java.util.Scanner;
import static java.lang.System.out;

public class Main {
    public static  void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        out.print("Integers or Text? (i/t): ");
        String intOrString = sc.next();

        out.print("How many values? ");
        int manyValues = sc.nextInt();

       try {
           if (manyValues < 1) {
               throw new IllegalArgumentException("Amount of values must be greather one");
           }

           PrintService printService = new PrintService();

           for (int i = 0; i < manyValues; i++) {
               out.print("Value " + (i + 1) + "º: ");
               if (intOrString == "i") {
                   int value = sc.nextInt();
                   printService.addValue(value);
               }

               else {
                   String value = sc.next();
                   printService.addValue(value);
               }
           }

           printService.print();
           out.println("First: " + printService.first());
       }

       catch (IllegalArgumentException | IllegalStateException err) {
           out.println("Error: " + err.getMessage());
       }
    }
}