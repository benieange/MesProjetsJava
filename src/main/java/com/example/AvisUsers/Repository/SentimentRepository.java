package com.example.AvisUsers.Repository;

import com.example.AvisUsers.Entities.Sentiment;
import com.example.AvisUsers.enums.TypeSentiment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SentimentRepository extends JpaRepository<Sentiment, Integer>
{
    @Query("SELECT t FROM Sentiment t WHERE t.texte like %:texte%")
    List<Sentiment> findByTexte(String texte);

    void deleteById(Integer idClient);

    List<Sentiment> findByType(TypeSentiment type);
}
