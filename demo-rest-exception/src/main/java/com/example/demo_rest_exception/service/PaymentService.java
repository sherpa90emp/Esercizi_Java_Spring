package com.example.demo_rest_exception.service;

import com.example.demo_rest_exception.exception.NotEnoughMoneyException;
import com.example.demo_rest_exception.model.dto.PaymentDetails;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    public PaymentDetails processPayment() {
        //simuliamo che sul conto non ci siano abbastanza fondi
        throw new NotEnoughMoneyException("Pagamento con Satispay: Non ci sono abbstanza fondi!");
    }

    public PaymentDetails processPaymentPayPal() {
        throw new NotEnoughMoneyException("Non ci sono abbastanza fondi sul tuo account PayPal!");
    }
}
