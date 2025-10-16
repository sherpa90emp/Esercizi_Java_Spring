package com.example.demo_spring_jdbc_transaction.model.dto;

import java.math.BigDecimal;

public class RichiestaBonifico {
    public int idMittente;
    public int idBeneficiario;
    public BigDecimal ammontare;

    public int getIdMittente() {
        return idMittente;
    }

    public void setIdMittente(int idMittente) {
        this.idMittente = idMittente;
    }

    public int getIdBeneficiario() {
        return idBeneficiario;
    }

    public void setIdBeneficiario(int idBeneficiario) {
        this.idBeneficiario = idBeneficiario;
    }

    public BigDecimal getAmmontare() {
        return ammontare;
    }

    public void setAmmontare(BigDecimal ammontare) {
        this.ammontare = ammontare;
    }
}
