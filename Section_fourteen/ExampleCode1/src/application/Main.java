package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            out.print("Insira a quantidade de unidades: ");
            int quantity = sc.nextInt();
            int[] array = new int[quantity];

            out.print("Diga o indíce que quer ver: ");
            int index = sc.nextInt();

            out.println("Valor do índice: " + array[index]);
        } catch (ArrayIndexOutOfBoundsException err) {
            out.println("\nHouve um erro!");
        } catch (InputMismatchException err) {
            out.println("\nHouve um erro!");
        }
    }
}