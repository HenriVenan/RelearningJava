package application;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkLevel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        out.print("Qual o departamento?: ");
        Department department = new Department(sc.next());

        out.println("Entre com os dados do usuário: ");
        out.print("Nome: ");
        String name = sc.next();

        out.print("Nível: ");
        WorkLevel workLevel = WorkLevel.valueOf(sc.next());

        out.print("Salário base: ");
        double baseSalary = sc.nextDouble();

        Worker worker = new Worker(name, workLevel, baseSalary, department);

        out.print("Quantos contratos possuí?: ");
        int amountContracts = sc.nextInt();

        for(int i = 0; i < amountContracts; i++) {

            out.println("\nContrato número #" + (i + 1));
            out.print("Data (dd/MM/yyyy): ");
            String date = sc.next();

            out.print("Valor por hora: ");
            double valuePerHour = sc.nextDouble();

            out.print("Horas trabalhadas: ");
            int hours = sc.nextInt();

            HourContract hourContract = new HourContract(
                    LocalDate.parse(date, format),
                    valuePerHour,
                    hours
            );

            worker.addContract(hourContract);
        }

        out.print("\nEntre com o mês e ano para calcular o ganho do funcionário (MM/yyyy):");
        String dates = sc.next();

        out.println("Nome: " + worker.getName());
        out.println("Departamento: " + worker.getDepartment().getDepartment());

//        double calc = worker
//                .getHourContracts()
//                .stream()
//                .filter(x -> x.getDate() == LocalDate.parse(dates, format))
//                .reduce(worker.getBaseSalary(), (a, b) -> a.totalValue() + b.totalValue());


        out.println("Ganhos de " + dates + ": ");
    }
}