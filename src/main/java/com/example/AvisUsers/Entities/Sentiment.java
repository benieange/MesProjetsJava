package com.example.AvisUsers.Entities;

import com.example.AvisUsers.enums.TypeSentiment;
import jakarta.persistence.*;
import org.hibernate.engine.internal.Cascade;

import static jakarta.persistence.CascadeType.MERGE;
import static jakarta.persistence.CascadeType.PERSIST;

@Entity
@Table(name = "sentiment")
public class Sentiment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String texte;
    private TypeSentiment type;
    @ManyToOne(cascade={PERSIST, MERGE})
    @JoinColumn(name="client_id")
    private Client client;

    public Sentiment() {
    }

    public Sentiment(Integer id, String texte, TypeSentiment type, Client client) {
        this.id = id;
        this.texte = texte;
        this.type = type;
        this.client = client;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }


    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public TypeSentiment getType() {
        return type;
    }

    public void setType(TypeSentiment type) {
        this.type = type;
    }
}
