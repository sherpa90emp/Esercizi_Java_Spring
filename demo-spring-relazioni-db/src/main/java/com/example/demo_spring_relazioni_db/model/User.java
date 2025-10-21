package com.example.demo_spring_relazioni_db.model;

import jakarta.persistence.*;

import java.util.List;

@Entity // dice al framework che questa classe ha una corrispettiva dabella sul db
@Table(name = "users") //permette di scriver il nome che vedremo sul db (non si scrive con lettere maiuscole come in java)
public class User {
    @Id // indica che questa è la primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // autoincrement
    @Column(name = "user_id") // cambio il nome alla colonna e sul db sarà user_id anche se su java la usiamo diversamente
    private long id;

    private String name;
    private String email;

    @OneToOne(mappedBy = "user")
    private UserDetails userDetails;

    @OneToMany(mappedBy = "user")
    private List<Post> posts;

    @ManyToMany
    @JoinTable(
            name = "user_project",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id")
    )
    private List<Project> projects;
}
