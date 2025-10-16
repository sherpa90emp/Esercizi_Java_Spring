package com.example.proxy_payments_rest_template.controller;

import com.example.proxy_payments_rest_template.model.Payment;
import com.example.proxy_payments_rest_template.proxy.PaymentsProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentsController {
    private final PaymentsProxy paymentsProxy;

    @Autowired
    public PaymentsController(PaymentsProxy paymentsProxy) {
        this.paymentsProxy = paymentsProxy;
    }

    @PostMapping("/pagamenti")
    public Payment createPayments(@RequestBody Payment payment) {
        return paymentsProxy.createPayment(payment);
    }
}
