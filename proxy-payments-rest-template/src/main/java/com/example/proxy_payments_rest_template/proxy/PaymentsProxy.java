package com.example.proxy_payments_rest_template.proxy;

import com.example.proxy_payments_rest_template.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Component //fornisce un bean di tipo PaymentsProxy al context
public class PaymentsProxy {
    //dipendenza di tipo RestTemplate
    private final RestTemplate rest;
    //url del server upstrem
    @Value("${name.service.url}") //permette di prendere i dati da application properties
    private String upstreamURL;
    @Autowired
    public  PaymentsProxy(RestTemplate rest) {
        this.rest = rest;
    }

    //metodo che delega chiamata al server di upstream
    public Payment createPayment(Payment payment) {
        // uri = url + risorsa
        String uri = upstreamURL + "/payments";
        //creao un oggetto heaqders per aggiungere header requestId
        HttpHeaders headers = new HttpHeaders();
        headers.add("requestId", UUID.randomUUID().toString());
        //riempio la richiesta con header e body
        HttpEntity<Payment> httpEntity = new HttpEntity<>(payment, headers);
        //delego la chiamata al server upstream e colleziono la sua risposta
        ResponseEntity<Payment> response =rest.exchange(
                uri, //uri del server upstream
                HttpMethod.POST, // metodo http della chiamata al server upstream
                httpEntity, // la richiesta http impacchettata con header e body
                Payment.class // la classe del body della risposta
        );
        return response.getBody(); // torno il body della risposta (oggetto Payment)
    }
}
