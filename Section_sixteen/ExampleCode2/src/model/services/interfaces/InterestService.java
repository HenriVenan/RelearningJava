package model.services.interfaces;

import java.security.InvalidParameterException;

public interface InterestService {
    public double getInterest();

    default double payment(double amount, int months) {
        if (months < 1) {
            throw new InvalidParameterException("Months bust be greather than zero");
        }

        return amount * Math.pow((1 + getInterest()), months);
    }
}
