package model.services;

import model.services.interfaces.InterestService;

import java.security.InvalidParameterException;

public class UsaInterestService implements InterestService {
    private final double interestRate;

    public UsaInterestService(double interestRate) {
        if (interestRate <= 0) {
            throw new InvalidParameterException("Interest rate must be greather zero");
        }

        this.interestRate = interestRate;
    }

    public double getInterest() {
        return interestRate;
    }
}
