package com.example.Stop.Code_1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControllerTemp {

    @GetMapping("/")
    public String home(Model model, @RequestParam(defaultValue = "0") Double temp) {
        if (temp != null) {
            model.addAttribute("temp", temp);
        }
        return "index";
    }

    @GetMapping("/string")
    public String homeString(Model model, @RequestParam(defaultValue = "0") String temp) {
        if (temp != null) {
            Double tempParse = Double.parseDouble(temp);
            model.addAttribute("temp", tempParse);
        }
        return "index";
    }

    @GetMapping("/index2")
    public String homeCalc(Model model, @RequestParam(defaultValue = "0") String temp) {
        try {
            if (temp != null) {
                Double tempParse = Double.parseDouble(temp);
                Double f = (tempParse * 9/5) + 32;
                Double k = tempParse + 273.15;
                model.addAttribute("fahrenheit", f);
                model.addAttribute("kelvin", k);
            }
        } catch (NumberFormatException ne) {
            model.addAttribute("errore", "Errore devi inserire un numero");
        }
        return "index2";
    }

}
