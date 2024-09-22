package repository;


import Model.Client;

import java.util.Optional;  

public interface ClientRepository {
    
    public Boolean addClient(Client client) ;
    public Optional<Client> findClientByName(String nom) ;
    
}
