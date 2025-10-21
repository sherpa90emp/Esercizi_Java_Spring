package com.example.demo_login.repository;

import com.example.demo_login.model.entity.ERole;
import com.example.demo_login.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    /**
     * Trova un ruolo dal suo nome.
     * @param name Il nome del ruolo.
     * @return un Optional che contiene il ruolo se trovato, altrimenti un Optional vuoto.
     */
    Optional<Role> findByName(ERole name);
}
