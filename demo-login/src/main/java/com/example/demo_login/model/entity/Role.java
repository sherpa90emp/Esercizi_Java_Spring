package com.example.demo_login.model.entity;

import jakarta.persistence.*;

/**
 * Classe che rappresenta i ruoli sul database.
 */
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Il nome del ruolo, memorizzato sul db.
     * @Enumerated(EnumType.STRING) assicura che il valore dell'enum venga salvato come stringa invece che come numero (es. 0, 1, ...).
     */
    @Enumerated(EnumType.STRING)
    @Column(length = 20) //usabile solo sui db
    private ERole name;

    public Role() {}

    public Role(ERole name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ERole getName() {
        return name;
    }

    public void setName(ERole name) {
        this.name = name;
    }
}
