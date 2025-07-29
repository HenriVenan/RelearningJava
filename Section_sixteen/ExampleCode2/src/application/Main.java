package application;

import model.services.BrazilianInterestService;
import model.services.UsaInterestService;
import model.services.interfaces.InterestService;

import java.security.InvalidParameterException;
import java.util.Scanner;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        out.print("Amount: ");
        double amount = sc.nextDouble();

        try {
            out.print("Months: ");
            int months = sc.nextInt();

            InterestService interestBrazil = new BrazilianInterestService(0.02);
            InterestService interestUsa = new UsaInterestService(0.01);
            out.println("\nPayments for " + months + " months: ");
            out.printf("Brazil: %.2f\n", interestBrazil.payment(amount, months));
            out.printf("USA: %.2f\n", interestUsa.payment(amount, months));

            sc.close();
        }

        catch (InvalidParameterException err) {
            out.println("Error: " + err.getMessage());
        }
    }
}