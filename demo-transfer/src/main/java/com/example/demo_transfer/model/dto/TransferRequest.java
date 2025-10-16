package com.example.demo_transfer.model.dto;

import java.math.BigDecimal;

public class TransferRequest {
    private long idSender;
    private long idReciver;
    private BigDecimal amount;

    public long getIdSender() {
        return idSender;
    }

    public void setIdSender(long idSender) {
        this.idSender = idSender;
    }

    public long getIdReciver() {
        return idReciver;
    }

    public void setIdReciver(long idReciver) {
        this.idReciver = idReciver;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
