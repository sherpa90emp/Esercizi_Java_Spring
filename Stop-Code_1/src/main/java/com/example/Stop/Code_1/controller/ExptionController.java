package com.example.Stop.Code_1.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class ExptionController {
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public String controlloErrore(MethodArgumentTypeMismatchException mismatchException, Model model) {
        model.addAttribute("errore", "Errore devi inserire un numero");
        model.addAttribute("temp", 0.0);
        return "index";
    }
}
