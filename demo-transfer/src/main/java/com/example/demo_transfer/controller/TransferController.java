package com.example.demo_transfer.controller;

import com.example.demo_transfer.model.dto.TransferRequest;
import com.example.demo_transfer.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransferController {
    private final TransferService transferService;

    @Autowired
    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping("/transfer")
    public void trnsferMoney(@RequestBody TransferRequest request) {

    }
}
