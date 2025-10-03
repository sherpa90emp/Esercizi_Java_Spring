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
}
