package application;

import entities.Account;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter account number: ");
        int number = sc.nextInt();

        System.out.print("Enter account holder: ");
        sc.next();
        String name = sc.next();

        System.out.print("Is the na initial deposit? (y/n): ");
        char initialDeposit = sc.next().charAt(0);

        Account acc = new Account(name, number);

        if(initialDeposit == 'y') {
            System.out.print("Enter initial deposit value: ");
            acc.deposit(sc.nextDouble());
        }

        System.out.println("\nAccount data:");
        System.out.println(acc);

        System.out.print("\nEnter a deposit value: ");
        acc.deposit(sc.nextDouble());

        System.out.println("Updated account data:");
        System.out.println(acc);

        System.out.print("\nEnter a withdraw value: ");
        acc.withdraw(sc.nextDouble());

        System.out.println("Updated account data:");
        System.out.println(acc);

        sc.close();
    }
}