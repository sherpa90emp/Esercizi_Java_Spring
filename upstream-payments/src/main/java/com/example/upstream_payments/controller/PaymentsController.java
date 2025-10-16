package com.example.upstream_payments.controller;

import com.example.upstream_payments.model.Payment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.logging.Logger;

@RestController
public class PaymentsController {
    //con cio capiano se il nostro server proxy chiama davvero effettua i payment
    private static Logger logger = Logger.getLogger(PaymentsController.class.getName());

    @PostMapping("/payments")
    public ResponseEntity<Payment> createPayment(@RequestHeader String requestId, @RequestBody Payment payment) {
        //loggo l'avvenuta transazione di pagamento (simula la chiamata al servizio)
        logger.info("Ricevuto pagamento con id " + requestId);
        logger.info(" - Totale pagamento = $ " + payment.getAmount());

        // valorizziamo la proprietà id dell'oggetto pagamento (simulando un id tornato dal servizio)
        payment.setId(UUID.randomUUID().toString());
        //torniamo la risposta HTTP al client (server proxy)
        return ResponseEntity.status(HttpStatus.OK) // torno 200 ok
                .header("requestId", requestId) //inserisco header con chiave "requestId"
                .body(payment); // inseriamo l'oggetto payment nel body come json
    }
}
