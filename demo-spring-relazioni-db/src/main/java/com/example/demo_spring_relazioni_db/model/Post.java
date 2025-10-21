package com.example.demo_spring_relazioni_db.model;

import jakarta.persistence.*;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 50)
    private String title;

    @Column(nullable = false, length = 150)
    private String message;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
