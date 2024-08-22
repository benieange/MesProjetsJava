package com.example.AvisUsers.Controller;

import com.example.AvisUsers.Entities.Sentiment;
import com.example.AvisUsers.Service.SentimentService;
import com.example.AvisUsers.enums.TypeSentiment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "sentiment", produces = APPLICATION_JSON_VALUE)
public class SentimentController {

    private final SentimentService sentimentService;

    public SentimentController(SentimentService sentimentService) {
        this.sentimentService = sentimentService;
    }
    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void creer(@RequestBody Sentiment sentiment){
        this.sentimentService.creer(sentiment);
    }

    @GetMapping(path = "rechercher")
    public  List<Sentiment> Rechercher(@RequestParam(required = false) TypeSentiment type){
        return this.sentimentService.rechercher(type);
    }
    @GetMapping(path = "rechercherParId/{id}")
    public @ResponseBody Optional<Sentiment> rechercherParId(@PathVariable("id") Integer id){
        return this.sentimentService.rechercherParId(id);
    }
    @GetMapping(path = "rechercherParTexte/{texte}")
    public List<Sentiment> rechercherParTexte(@PathVariable String texte){
        return this.sentimentService.rechercherParTexte(texte);
    }
    @DeleteMapping(path = "supprimerParId/{idClient}")
    public void supprimerParId(@PathVariable Integer idClient){
        this.sentimentService.supprimerParId(idClient);
    }



}
