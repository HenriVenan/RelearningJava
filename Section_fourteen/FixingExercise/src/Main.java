
import model.entities.Account;
import model.exceptions.DomainException;

import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            out.println("Enter the account data");
            out.print("Number: ");
            int number = sc.nextInt();

            out.print("Holder: ");
            String holder = sc.next();

            out.print("Initial Balance: ");
            double initialBalance = sc.nextDouble();

            out.print("Withdraw Limit: ");
            double withdrawLimit = sc.nextDouble();

            out.print("\nEnter the amount for withdraw: ");
            double withdraw = sc.nextDouble();

            Account acc = new Account(number, holder, initialBalance, withdrawLimit);
            acc.withdraw(withdraw);

            out.println(acc);
        }

        catch (InputMismatchException err) {
            out.println("ERROR: Enter valid data!");
        }

        catch (DomainException err) {
            out.println("ERROR: " + err.getMessage());
        }

    }
}