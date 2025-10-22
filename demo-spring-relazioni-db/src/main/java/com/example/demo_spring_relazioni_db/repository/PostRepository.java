package com.example.demo_spring_relazioni_db.repository;

import com.example.demo_spring_relazioni_db.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Estendere jpaRepository fornisce alla nostra interfaccia dei metodi di base per operazioni CRUD, tipizzato con due generici T U
 * T = il tipo di entity che il repository gestisce
 * U = tipo di primary key (o id) che questa entity possiede
 */
public interface PostRepository extends JpaRepository<Post, Long> {
}
