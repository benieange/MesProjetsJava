package com.example.AvisUsers.Entities;


import jakarta.persistence.*;
import org.hibernate.mapping.PrimaryKey;
import org.hibernate.mapping.Value;

@Table(name = "Client")
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    @Column(unique = true)
    private String email;

    public Client() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
