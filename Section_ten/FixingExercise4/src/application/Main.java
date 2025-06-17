package application;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos números você vai digitar: ");
        int quantNumbers = sc.nextInt();
        int[] numbers = new int[quantNumbers];

        System.out.println();

        for(int i = 0; i < quantNumbers; i++) {
            System.out.print("Digite o número: ");
            numbers[i] = sc.nextInt();
        }

        int sumPars = 0;

        System.out.println("\nNúmeros Pares");
        for(int i = 0; i < quantNumbers; i++) {
            if((numbers[i] % 2) == 0) {
                System.out.printf("[%d] ", numbers[i]);
                sumPars += 1;
            }
        }

        System.out.println("\nNúmero de pares: " + sumPars);

    }
}