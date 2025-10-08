package com.example.demo_rest_controller.controller;

import com.example.demo_rest_controller.model.Country;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController {
    @GetMapping("/italy")
    public Country italy() { //quando un metodo di un rest controller torna un oggetto, questo viene trasformato in json (nella risposta)
        return Country.of("italy", 59);
    }

    @GetMapping("/francia")
    public Country francia() {
        return Country.of("francia", 66);
    }

    @GetMapping("/countries")
    public List<Country> allCountries() { //se un metodo torna una collezione di oggetti, la risposta conterrà un array json contenente gli oggetti
        Country c1 = Country.of("italy", 59);
        Country c2 = Country.of("francia", 66);
        return List.of(c1,c2);
    }

    @GetMapping("/germania")
    public ResponseEntity<Country> germania() { //se ho bisogno di modificare lo status http della risposta, oppure aggiungere degli header: ritorno responseEntity<T> (il tipo t generico è l'oggetto che sarà inserito nel body della richiesta)
        Country germany = Country.of("germany", 84);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED) //settato status code a 202
                .header("continent", "Europe") // aggiunti vari headers
                .header("capital", "Berlin")
                .header("favorite_food", "Kartoffeln")
                .body(germany); //riempito il body con l'oggetto da tornare
    }
}
