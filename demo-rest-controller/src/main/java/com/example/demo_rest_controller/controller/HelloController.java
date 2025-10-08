package com.example.demo_rest_controller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //con @Controller i metodi ritornano una stringa che corrisponde all nome di una view
public class HelloController {

    @ResponseBody //indica che l'oggetto ritornato dal metodo sarà inserito nel body della risposta HTTP
    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }
}
