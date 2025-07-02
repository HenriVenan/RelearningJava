package application;

import entities.Employee;
import entities.OutsourcedEmployee;

import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        out.print("Enter the number of employees: ");
        int numberOfEmployees = sc.nextInt();
        ArrayList<Employee> employees = new ArrayList<>();

        for (int i = 0; i < numberOfEmployees; i++) {
            out.printf("\nEmployee #%d data: ", (i + 1));
            out.print("\nOutsorced (y/n): ");
            char outsorced = sc.next().charAt(0);

            if((outsorced != 'y') && (outsorced != 'n')) {
                out.println("Digite uma opção válida!");
                System.exit(0);
            }

            out.print("Name: ");
            String name = sc.next();

            out.print("Hours: ");
            int hours = sc.nextInt();

            out.print("Value per Hours: ");
            double valuePerHours = sc.nextDouble();

            switch (outsorced) {
                case 'y':
                    out.print("Additional Charge: ");
                    double additionalCharge = sc.nextDouble();
                    employees.add(new OutsourcedEmployee(
                            name,
                            hours,
                            valuePerHours,
                            additionalCharge));
                break;

                case 'n':
                    employees.add(new Employee(
                            name,
                            hours,
                            valuePerHours));
                break;
            }
        }

        out.println("\nPAYMENTS: ");
        for (Employee employee : employees) {
            out.println(employee);
        }
    }
}