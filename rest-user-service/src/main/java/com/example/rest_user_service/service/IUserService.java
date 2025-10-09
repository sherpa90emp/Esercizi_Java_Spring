package com.example.rest_user_service.service;

import com.example.rest_user_service.model.dto.User;

import java.util.List;

/**
 * Interfaccia per la gestione delle operazioni CRUD sugli Utenti
 */
public interface IUserService {
    //Create -> post

    /**
     * Crea un nuovo utente.
     * @param user L'utente da creare.
     * @return L'utente creato o null se esiste già.
     */
    User createUser(User user);

    //Read -> get
    /**
     * Restituisce gli utenti del sistema.
     * @return Uan lista di Users.
     */
    List<User> getAllUsers();

    /**
     * Restituisce gli studenti in ordine email, name, surname ascendente.
     * @return Una lista di Users.
     */
    List<User> getAllUsersAsc();

    /**
     * Restituisce gli studenti in ordine email, name, surname discendente.
     * @return Una lista di Users.
     */
    List<User> getAllUserDesc();

    /**
     * Restituisce un utente dato il suo indirizzo email.
     * @param email L'email dell'utente
     * @return L'utente corrispondente o null se non esiste
     */
    User getUserByEmail(String email);

    //Update -> put
    /**
     * Aggiorna utente esistente.
     * @param email L'email dell'utente da aggiornare.
     * @param updatedUser I dati aggiornati dall'utente.
     * @return L'utente aggiornato o null se non esiste.
     */
    User updateUser(String email, User updatedUser);

    //Delete -> delete
    /**
     * Elimina un utente dato il suo indirizzo email;
     * @param email l'email dell'utente da eliminare.
     * @return True se l'utente viene eliminato, False altrimenti
     */
    boolean deleteUser(String email);
}
