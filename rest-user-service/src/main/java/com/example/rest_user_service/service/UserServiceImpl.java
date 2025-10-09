package com.example.rest_user_service.service;

import com.example.rest_user_service.model.dto.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementazione dell'interfaccia di servizio per la gestione degli utenti.
 */
@Service
public class UserServiceImpl implements IUserService {
    /**
     * Teniamo la lista degli utenti in memoria.
     * TODO: dovremmo spostarlo nel repository.
     */
    private final List<User> users = new ArrayList<>();

    @Override
    public User createUser(User user) {
        for (User u : users)
            if (user.email().equals(u.email()))
                return null;
        users.add(user);
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        //Rispondo con un clone della lista per impedire side effect
        return new ArrayList<>(users);
    }

    @Override
    public List<User> getAllUsersAsc() {
        return users.stream()
                .sorted(Comparator.comparing(User::email))
                .toList();
    }

    @Override
    public List<User> getAllUserDesc() {
        return users.stream()
                .sorted(Comparator.comparing(User::email).reversed())
                .toList();
    }

    @Override
    public User getUserByEmail(String email) {
//        for (User u : users)
//            if (u.email().equals(email))
//                return u;
//        return null;
        return users.stream() //versione lambda, è la stessa cosa del for each
                .filter(users -> users.email().equals(email))
                .findFirst()
                .orElse(null);
    }

    @Override
    public User updateUser(String email, User updatedUser) {
        //per modificare è necessario usare il for classico
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).email().equals(email)) {
                users.set(i, updatedUser);
                return updatedUser;
            }
        }
        return null;
    }

    @Override
    public boolean deleteUser(String email) {
        return users.removeIf(users -> users.email().equals(email));
    }
}
