package com.example.simple_webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //Annotation stereotype standard per controller; crea un bean di tipo HelloController nel context di spring, che viene arricchito di funzionalità delle Servlet. I suoi metodi tornano una stringa che rappresentano il nome di una view
public class HelloController {

    private static final String HTML_CONTENT = """
            <!Document html>
            <html>
            <head>
            <title>Titolo pagina</title>
            <style> body { text-align: center; margin: 32px; }
            h1 { color: red; }
            </style>
            </head>
            <body>
            <h1>Benvenuto nella bellissima app SpringBoot</h1>
            <p>Hello World! Hello World!</>
            <p> Questa pagina è stata creata con un HTML statico inserito in una stringa JAVA</p>
            </body>
            </html>
            """;

    //mapping di una url a un metodo
    @GetMapping("/hello")
    @ResponseBody // il valore di ritorno del metodo è in realtà il corpo della response
    public String hello() {
        return HTML_CONTENT;
    }
}
