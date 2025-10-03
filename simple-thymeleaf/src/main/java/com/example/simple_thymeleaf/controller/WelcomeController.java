package com.example.simple_thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class WelcomeController {
    @GetMapping("/welcome")
    public String welcome(Model model, @RequestParam(required = false) String nome) //annotation request parm permette di inserire una variabile in query string e usarla in questo modo
     {
        if (nome == null) nome = "Pino";
        //aggiungiamo un attributo di tipo string di valore "Pino" al model; il quale viene fornito da spring in ingresso al metodo
        model.addAttribute("username", nome);

        //aggiungiamo una lista di stringhe al modello
         List<String> listaTask = List.of(
                 "Studiare Springboot",
                 "Eseguire stop and code",
                         "relax");
         model.addAttribute("attivita", listaTask);
        //torno una stringa che rappresenta il nome della view che vogliamo tornare al client (senza il .html)
        return "welcome";
    }

    @GetMapping("/pippo")
    public String pippo() {
        return "pippo";
    }
}
