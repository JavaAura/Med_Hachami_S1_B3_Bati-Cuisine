package com.baticuisine.repository;


import java.util.Optional;

import com.baticuisine.Model.Client;  

public interface ClientRepository {
    
    public Boolean addClient(Client client) ;
    public Optional<Client> findClientByName(String nom) ;
    
}
