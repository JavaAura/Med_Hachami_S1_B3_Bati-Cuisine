package com.baticuisine.service;

import java.util.Optional;

import com.baticuisine.Model.Client;

public interface ClientService {
    public void addClient(Client client);
    public Optional<Client> findClientByName(String nom) ;
}

