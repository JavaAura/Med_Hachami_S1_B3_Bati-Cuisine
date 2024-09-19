package repository;

import java.sql.SQLException;

import Model.Client;

import java.util.Optional;  

public interface ClientRepository {
    
    public Boolean addClient(Client client) throws SQLException;
    public Optional<Client> findClientByName(String nom) throws SQLException;
    
}
