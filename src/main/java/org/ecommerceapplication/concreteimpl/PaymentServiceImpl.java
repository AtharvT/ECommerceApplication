package org.ecommerceapplication.concreteimpl;

import org.ecommerceapplication.service.IPaymentService;

public class PaymentServiceImpl implements IPaymentService {
    @Override
    public boolean processPayment(double amount) {
        System.out.println("Payment processed successfully");
        return true;
    }
}
