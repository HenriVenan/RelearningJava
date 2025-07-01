package application;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

       Scanner sc = new Scanner(System.in);

       System.out.print("Quantos números você vai digitar?: ");
       int quantNumbers = sc.nextInt();
       int[] numbers = new int[quantNumbers];

       for(int i = 0; i < quantNumbers; i++) {
           System.out.printf("Digite o %dº número: ", (i + 1));
           numbers[i] = sc.nextInt();
       }

       System.out.println("Números Negativos: \n");

       for(int i = 0; i < quantNumbers; i++) {
           if(numbers[i] < 0) {
                System.out.println(numbers[i]);
           }
       }

    }
}