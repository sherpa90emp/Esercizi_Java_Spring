package com.example.rest_user_service.model.dto;

/**
 * Un record è una classe di oggetti immutabili.
 * @param name Il nome dell'utente.
 * @param surname Il cognome dell'utente.
 * @param email L'email dell'utente.
 */
public record User( //le () indicano già un costruttore
        String name, //le proprietà del record user
        String surname,
        String email
) {
    /**
     * Validatore del costruttore per il record User.
     * Valida che i campi non siano nulli o vuoti
     * @throws IllegalArgumentException se uno dei campi è nullo o vuoto
     */
    public User {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Name cannot be null");
        if (surname == null || surname.isBlank())
            throw new IllegalArgumentException("Surname cannot be null");
        if (email == null || email.isBlank())
            throw new IllegalArgumentException("Email cannot be null");
    }
}
