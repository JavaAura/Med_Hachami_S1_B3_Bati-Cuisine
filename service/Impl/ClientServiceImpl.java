package service.Impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Model.Client;
import repository.ClientRepository;
import service.ClientService;

public class ClientServiceImpl implements ClientService{

    private static final Logger logger = LoggerFactory.getLogger(ClientServiceImpl.class);


    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    @Override
    public void addClient(Client client) {

        Boolean 
        isAdded = this.clientRepository.addClient(client);

        
        if(isAdded){
            System.out.println("Client "+ client.getNom() + " ajouté avec succès.");
        }else{
            logger.warn("Le client {} n'a pas pu être ajouté.", client.getNom());
        }
    }

    @Override
    public Optional<Client> findClientByName(String nom)  {

        Optional<Client> clientOpt = this.clientRepository.findClientByName(nom);

        return clientOpt;
    }
    
}
