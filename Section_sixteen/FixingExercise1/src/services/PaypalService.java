package services;

import services.interfaces.OnlinePaymentService;

public class PaypalService implements OnlinePaymentService {

    public Double paymentFee(Double amount) {
        return amount + (amount * 0.02);
    }

    public Double interest(Double amount, int months) {
        return amount + (amount * 0.01 * months);
    }
}
