package entities;

import entities.enums.WorkLevel;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class Worker {
    private String name;
    private WorkLevel workLevel;
    private double baseSalary;
    private Department department;
    private ArrayList<HourContract> hourContracts;

    public Worker(
            String name,
            WorkLevel workLevel,
            double baseSalary,
            Department department
    ) {
        this.name = name;
        this.workLevel = workLevel;
        this.baseSalary = baseSalary;
        this.department = department;
        this.hourContracts = new ArrayList<>();
    }

    public void addContract(HourContract contract) {
        hourContracts.add(contract);
    }

    public void removeContract(HourContract contract) {
        hourContracts
                .stream()
                .filter(x -> x.getDate() == contract.getDate())
                .findFirst()
                .ifPresent(fContract -> hourContracts.remove(fContract));
    }

    public double income(List<HourContract> contract) {
        double calc = 0;

        for (HourContract hourContract : contract) {
            calc += hourContract.totalValue();
        }

        return  calc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkLevel getWorkLevel() {
        return workLevel;
    }

    public void setWorkLevel(WorkLevel workLevel) {
        this.workLevel = workLevel;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<HourContract> getHourContracts() {
        return hourContracts;
    }
}
