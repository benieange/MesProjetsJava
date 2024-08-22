package com.example.AvisUsers.Repository;

import com.example.AvisUsers.Entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {

        Client findByEmail(String email);
}
