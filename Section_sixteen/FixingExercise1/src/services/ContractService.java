package services;

import entities.Contract;
import entities.Installment;
import services.interfaces.OnlinePaymentService;

import java.time.LocalDate;

public class ContractService {
    private OnlinePaymentService onlinePaymentService;

    public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract(Contract contract, Integer months) {
        double installmentValue = contract.getTotalValue() / months;

        for (int i = 0; i < months; i++) {
            double valueInstallmentTax = onlinePaymentService
                    .paymentFee(onlinePaymentService.interest(installmentValue, (i + 1)));
            LocalDate installmentDate = contract.getDate().plusMonths(i+1);

            contract.setInstallments(new Installment(installmentDate, valueInstallmentTax));
        }
    }
}
