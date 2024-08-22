package com.example.AvisUsers.Service;

import com.example.AvisUsers.Entities.Client;
import com.example.AvisUsers.Entities.Sentiment;
import com.example.AvisUsers.Repository.SentimentRepository;
import com.example.AvisUsers.enums.TypeSentiment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SentimentService {

    private ClientService clientService;
    private final SentimentRepository sentimentRepository;

    public SentimentService(SentimentRepository sentimentRepository, ClientService clientService) {
        this.sentimentRepository = sentimentRepository;
        this.clientService = clientService;
    }

    public void creer(Sentiment sentiment) {
        Client client=this.clientService.lireouCreer(sentiment.getClient());
        sentiment.setClient(client);

        //analyse du sentiment
        if(sentiment.getTexte().contains("pas"))
        {
            sentiment.setType(TypeSentiment.NEGATIF);
        }else {
            sentiment.setType(TypeSentiment.POSITIF);
        }

        this.sentimentRepository.save(sentiment);
    }

    public List<Sentiment> rechercher(TypeSentiment type) {
        if (type != null) {
           return this.sentimentRepository.findByType(type);
        } else
        { return this.sentimentRepository.findAll();}

    }

    public Optional<Sentiment> rechercherParId(Integer id) {
        return this.sentimentRepository.findById(id);
    }

    public List<Sentiment> rechercherParTexte(String texte) {
        return this.sentimentRepository.findByTexte(texte);
    }
    public void supprimerParId(Integer idClient) {
        this.sentimentRepository.deleteById(idClient);
    }

}
