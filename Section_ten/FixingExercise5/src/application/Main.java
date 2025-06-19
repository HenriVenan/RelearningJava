package application;

import entities.Employer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.lang.System.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);

        out.print("How many employees will be registered?: ");
        int employeesQuantity = sc.nextInt();
        List<Employer> employees = new ArrayList<>();

        for(int i = 0; i < employeesQuantity; i++) {
            out.println("\nEmployee #" + (i + 1));
            out.print("Id: ");
            int id = sc.nextInt();

            while(hasId(employees, id)) {
                out.println("\nThis ID does not exist! Try again");
                out.print("Id: ");
                id = sc.nextInt();
            }

            out.print("Name: ");
            String name = sc.next();

            out.print("Salary: ");
            double salary = sc.nextDouble();

            employees.add(new Employer(id, name, salary));
        }

        out.println();

        Employer choiceEmployer;

        do {
            out.print("Enter the employee ID that will have salary increase: ");
            int id = sc.nextInt();
           choiceEmployer  = employees
                    .stream()
                    .filter(x -> x.getId() == id)
                    .findFirst()
                    .orElse(null);
        } while (choiceEmployer == null);

        out.print("Enter the percent: ");
        double percent = sc.nextDouble();
        choiceEmployer.increaseSalary(percent);


        out.println("\nList of employees:");
        for (Employer employ : employees) {
            out.println(employ);
        }
    }

    static boolean hasId(List<Employer> employees, int id) {
        Employer employ = employees
                .stream()
                .filter(x -> x.getId() == id)
                .findFirst()
                .orElse(null);

        return employ != null;
    }
}