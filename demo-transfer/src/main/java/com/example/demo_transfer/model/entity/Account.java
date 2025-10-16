package com.example.demo_transfer.model.entity;

import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

public class Account {
    @Id //battezza la proprietà come id PK
    private long id;
    private  String Nome;
    private BigDecimal amount;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
