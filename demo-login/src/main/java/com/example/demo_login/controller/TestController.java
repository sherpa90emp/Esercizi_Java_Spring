package com.example.demo_login.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    //endpoint accessibile a chiunque
    @GetMapping("/all")
    public String allAcces() {
        return "Public Content.";
    }

    //endpoint accessibile solo agli user o admin
    @GetMapping("/user")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')") //applichiamo la sicurezza al livello di metodo
    public String userAccess() {
        return "User Content.";
    }

    //endpoint visibile solo agli admin
    @GetMapping("/admin")
    @PreAuthorize(("hasRole('ADMIN')"))
    public String adminAccess() {
        return "Admin Board.";
    }
}
