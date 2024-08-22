package com.example.AvisUsers.Service;

import com.example.AvisUsers.Entities.Client;
import com.example.AvisUsers.Repository.ClientRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void creer(Client client) {
        Client clientdansmabdd= clientRepository.findByEmail(client.getEmail());

        if(clientdansmabdd == null) {
            this.clientRepository.save(client);
        }
    }
    public List<Client> rechercher(){
        return this.clientRepository.findAll();
    }

    public Client lire(int id) {
        Optional<Client> optionalClient = this.clientRepository.findById(id);
        return optionalClient.orElse(null);
    }

    public Client lireouCreer(Client clientAcreer) {
        Client clientdansmabdd= clientRepository.findByEmail(clientAcreer.getEmail());

        if(clientdansmabdd == null) {
            clientdansmabdd=this.clientRepository.save(clientAcreer);
        }
        return clientdansmabdd;
    }
}
