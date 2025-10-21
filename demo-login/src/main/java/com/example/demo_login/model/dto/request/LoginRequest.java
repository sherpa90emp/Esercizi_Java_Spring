package com.example.demo_login.model.dto.request;

import jakarta.validation.constraints.NotBlank;

/**
 * Rappresenta il payload (contenuto del body) di una richiesta di login.
 * Contiene i campi necessari all'autenticazione di un utente.
 */
public class LoginRequest {
    @NotBlank
    private String username;

    @NotBlank
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
