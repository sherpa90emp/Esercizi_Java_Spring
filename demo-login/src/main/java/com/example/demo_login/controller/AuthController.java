package com.example.demo_login.controller;

import com.example.demo_login.model.dto.request.LoginRequest;
import com.example.demo_login.model.dto.request.SignupRequest;
import com.example.demo_login.repository.RoleRepository;
import com.example.demo_login.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    //endpoint di login
    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest loginRequest) {
        //decoding jwt
        return null;
    }
    //endpoint di registrazione
    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody SignupRequest signupRequest) {
        //encoding jwt
        return null;
    }
}
