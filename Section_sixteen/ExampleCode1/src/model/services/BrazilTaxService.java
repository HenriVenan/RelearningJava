package model.services;

import model.services.interfaces.TaxService;

public class BrazilTaxService implements TaxService {

    public Double tax(double amount) {
        if (amount <= 100) {
            return amount * 0.20;
        }

        return amount * 0.15;
    }
}
