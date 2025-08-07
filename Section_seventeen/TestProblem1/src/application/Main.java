package application;

import entities.Country;
import services.OrderingService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Country> countries = new ArrayList<>();

        out.print("Enter amount countries will be added: ");
        int amountCountries = sc.nextInt();

        for (int i = 0; i < amountCountries; i++) {
            out.println("\n" + (i + 1) + "º country: ");
            out.print("Name: ");
            String name = sc.next();

            out.print("Inhabitants in millions: ");
            int inhabitants = sc.nextInt();

            countries.add(new Country(name, inhabitants));
        }

        List<Country> minAndMax = OrderingService.orderingCountries(countries);

        out.println("\nCountries with the largest and smallest number of inhabitants: ");
        out.println(minAndMax.get(0));
        out.println(minAndMax.get(1));

    }
}