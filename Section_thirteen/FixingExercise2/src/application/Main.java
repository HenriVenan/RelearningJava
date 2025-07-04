package application;

import entities.LegalEntity;
import entities.NaturalPerson;
import entities.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        out.print("Enter the number of tax payers: ");
        int taxPayers = sc.nextInt();
        List<Person> listPersons = new ArrayList<>();

        for (int i = 0; i < taxPayers; i++) {
            out.println("\nTax Payer #" + (i + 1) + " data: " );

            out.print("Individual or Company (i/c): ");
            char individualOrCompany = sc.next().charAt(0);

            out.print("Name: ");
            String name = sc.next();

            out.print("Annual Income: ");
            double annualIncome = sc.nextDouble();

            if (individualOrCompany == 'i') {
                out.print("Health Expenditures: ");
                double healthSpending = sc.nextDouble();
                listPersons.add(new NaturalPerson(
                        name,
                        annualIncome,
                        healthSpending));
            }

            else {
                out.print("Number of Employees: ");
                int amountEmployee = sc.nextInt();
                listPersons.add(new LegalEntity(
                        name,
                        annualIncome,
                        amountEmployee));
            }
        }

        double calc = 0;

        out.println("\nTaxes Paid: ");
        for (Person person : listPersons) {
            out.println(person);
            calc += person.calcTax();
        }

        out.println("\nTotal Taxes: " + String.format("%.2f", calc));
    }
}