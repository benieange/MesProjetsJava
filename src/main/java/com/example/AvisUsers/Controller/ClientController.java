package com.example.AvisUsers.Controller;

import com.example.AvisUsers.Entities.Client;
import com.example.AvisUsers.Entities.Sentiment;
import com.example.AvisUsers.Repository.ClientRepository;
import com.example.AvisUsers.Service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "client")
public class       ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void creer(@RequestBody Client client) {
        this.clientService.creer(client);
    }

    @GetMapping(path = "rechercher", produces = APPLICATION_JSON_VALUE)
    public List<Client> rechercher(){
        return this.clientService.rechercher();
    }
    @GetMapping(path = "{id}")
    public Client lire(@PathVariable int id){
        return this.clientService.lire(id);
    }
    @PutMapping(path = "modifier")
    public Client modifier(int id){
        return this.clientService.lire(id );
    }
}
