package com.example.demo_jdbc_spring.controller;

import com.example.demo_jdbc_spring.model.entity.Acquisto;
import com.example.demo_jdbc_spring.repository.AcquistiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AcquistiController {

    private final AcquistiRepository repository;

    @Autowired
    public AcquistiController(AcquistiRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public  void  salvaAcquisto(@RequestBody Acquisto acquisto) {
        repository.salvaAcquisto(acquisto);
    }

    @GetMapping
    public List<Acquisto> recuperaAcquisti() {
        return  repository.recuperaAcquisti();
    }
}
