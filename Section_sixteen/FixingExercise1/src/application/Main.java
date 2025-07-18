package application;

import entities.Contract;
import entities.Installment;
import services.ContractService;
import services.PaypalService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter dateFormmater = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        out.println("Entre com os dados do contrato:");
        out.print("Número: ");
        int number = sc.nextInt();

        out.print("Data (dd/MM/yyyy): ");
        LocalDate date = LocalDate.parse(sc.next(), dateFormmater);

        out.print("Valor do Contrato: ");
        double contractValue = sc.nextDouble();

        out.print("Número de Parcelas: ");
        int numberInstallments = sc.nextInt();

        Contract contract = new Contract(number, date, contractValue, new ArrayList<>());

        ContractService contractService = new ContractService(new PaypalService());
        contractService.processContract(contract, numberInstallments);

        ArrayList<Installment> installmentList = contract.getInstallments();
        out.println("\nParcelas: ");
        for (Installment installment : installmentList) {
            out.println(installment);
        }
    }
}