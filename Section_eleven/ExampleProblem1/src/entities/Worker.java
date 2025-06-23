package entities;

import entities.enums.WorkLevel;

import java.util.List;
import java.util.stream.Collectors;

public class Worker {
    private String name;
    private WorkLevel workLevel;
    private double baseSalary;
    private Department department;
    private List<HourContract> hourContracts;

    public Worker(
            String name,
            WorkLevel workLevel,
            double baseSalary,
            Department department,
            List<HourContract> hourContracts
    ) {
        this.name = name;
        this.workLevel = workLevel;
        this.baseSalary = baseSalary;
        this.department = department;
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
