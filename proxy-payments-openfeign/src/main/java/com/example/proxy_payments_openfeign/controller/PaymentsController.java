package com.example.proxy_payments_openfeign.controller;

import com.example.proxy_payments_openfeign.model.Payment;
import com.example.proxy_payments_openfeign.proxy.PaymentsProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class PaymentsController {
    private final PaymentsProxy proxy;

    @Autowired
    public PaymentsController(PaymentsProxy proxy) {
        this.proxy = proxy;
    }

    @PostMapping("/pagamenti")
    public Payment createPayment(@RequestBody Payment payment) {
        //genero un requestId da inserire in header
        String requestId = UUID.randomUUID().toString();
        //delego la chiamata al proxy
        return  proxy.createPayments(requestId, payment);
    }
}
