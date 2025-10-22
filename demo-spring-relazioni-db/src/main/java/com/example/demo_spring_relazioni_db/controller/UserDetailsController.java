package com.example.demo_spring_relazioni_db.controller;

import com.example.demo_spring_relazioni_db.model.UserDetails;
import com.example.demo_spring_relazioni_db.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/details")
public class UserDetailsController {
    private UserDetailsRepository userDetailsRepository;

    @Autowired
    public UserDetailsController(UserDetailsRepository userDetailsRepository) {
        this.userDetailsRepository = userDetailsRepository;
    }

    @GetMapping
    public List<UserDetails> getAllUserDetails() {
        return userDetailsRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDetails> getUserDetailsById(@PathVariable Long id) {
        UserDetails userDetails = userDetailsRepository.findById(id).orElse(null);
        if (userDetails == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(userDetails);
    }

    @PostMapping
    public UserDetails createUserDetails(@RequestBody UserDetails userDetails) {
        return userDetailsRepository.save(userDetails);
    }
}
