package com.example.proxy_payments_openfeign.proxy;

import com.example.proxy_payments_openfeign.model.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "payments", url = "${name.service.url}") //@FeingClient battezza il componente come client http openfeign
// url = indirizzo del server upstrem
// ${} -> prendiamo dati da application properties
public interface PaymentsProxy {
    //metodo astratto, viene implementato in automatico da openfeign
    @PostMapping("/payments")
    Payment createPayments(
            @RequestHeader String requestId,
            @RequestBody Payment payment);
    // devono essere identici alla chiamata
}
