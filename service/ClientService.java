package service;

import java.util.Optional;

import Model.Client;

public interface ClientService {
    public void addClient(Client client);
    public Optional<Client> findClientByName(String nom) ;
}

