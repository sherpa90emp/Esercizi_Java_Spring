package com.example.demo_rest_exception.controller;

import com.example.demo_rest_exception.exception.NotEnoughMoneyException;
import com.example.demo_rest_exception.model.dto.ErrorDetails;
import com.example.demo_rest_exception.model.dto.PaymentDetails;
import com.example.demo_rest_exception.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    //? vuol dire che possiamo tornare qualsiasi oggetto come body della risposta HTTP ResponseEntity<?>
    @PostMapping("/payment")
    public ResponseEntity<PaymentDetails> makePayment(@RequestBody PaymentDetails paymentDetails) {
        System.out.println("Pagamento effettuato di $ " + paymentDetails.getAmmount());
        return ResponseEntity.accepted().body(paymentDetails);
    }

    @PostMapping("/paymentPayPal")
    public ResponseEntity<PaymentDetails> makePaymentPayPal() {
        PaymentDetails paymentDetails = paymentService.processPaymentPayPal();
        return ResponseEntity.ok(paymentDetails); // ok è una scorciatoia per status .ok
    }
}
