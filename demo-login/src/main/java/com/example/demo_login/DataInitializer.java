package com.example.demo_login;

import com.example.demo_login.model.entity.ERole;
import com.example.demo_login.model.entity.Role;
import com.example.demo_login.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Viene eseguita all'avvio dell'applicazione per inserire dati nel db.
 */
@Component
public class DataInitializer implements CommandLineRunner {
    @Autowired
    private RoleRepository roleRepository;
    /**
     * Viene eseguita all'avvio dell'applicazione.
     */
    @Override
    public void run(String... args) throws Exception { //(String...args) vuoldire che accetta più argomenti
        if (roleRepository.count() == 0) {
            //crea e salva i ruoli di base
            roleRepository.save(new Role(ERole.ROLE_USER));
            roleRepository.save(new Role(ERole.ROLE_ADMIN));
            System.out.println("Ruoli inizializzati del database");
        }

    }
}
