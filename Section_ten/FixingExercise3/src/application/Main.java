package application;

import entities.Users;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos usuários serão digitados: ");
        int quantUsers = sc.nextInt();
        Users[] users = new Users[quantUsers];

        for(int i = 0; i < quantUsers; i++) {
            System.out.printf("\nDados da %dº pessoa: \n", (i + 1));
            System.out.print("Nome: ");
            String name = sc.next();

            System.out.print("Idade: ");
            int age = sc.nextInt();

            System.out.print("Altura: ");
            double height = sc.nextDouble();

            users[i] = new Users(name, age, height);
        }

        double sumHeights = 0;
        int less16 = 0;

        for(int i = 0; i < quantUsers; i++) {
            sumHeights += users[i].getHeight();

            if(users[i].getAge() < 16) {
                less16 += 1;
            }
        }

        System.out.printf("\nAltura média: %.2f", (sumHeights / quantUsers));
        System.out.printf("\nPessoas com menos de 16 anos: %.2f%%  \n", ((less16 / (double) quantUsers) * 100));

        for(int i = 0; i < quantUsers; i++) {
            if(users[i].getAge() < 16) {
                System.out.println(users[i].getName());
            }
        }

    }
}