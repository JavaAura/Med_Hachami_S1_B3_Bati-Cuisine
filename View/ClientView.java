package View;

import java.sql.SQLException;
import java.util.Optional;

import Model.Client;
import Model.MainOeuvre;
import Model.Material;
import Model.Projet;
import Utils.Utils;
import service.ClientService;
import service.MainOeuvreService;
import service.MaterialService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClientView {
    private static final Logger logger = LoggerFactory.getLogger(ClientView.class);
    final ClientService clientService;
    final MaterialService materialService;
    final MainOeuvreService mainOeuvreService;


    public ClientView(){
        this.clientService = new ClientService();
        this.mainOeuvreService = new MainOeuvreService();
        this.materialService = new MaterialService();
    }


    public void showMenu(){
        int choice = 0;

        do {
            Utils.clear();

            System.out.println("=== Recherche client ===");
            System.out.println("Souhaitez-vous chercher un client existant ou en ajouter un nouveau ?");
            System.out.println("1. Chercher un client existant");
            System.out.println("2. Ajouter un nouveau client");
            System.out.println("3. Quitter");


            choice = Utils.getInputInt("Choisissez une option :\n");

            switch (choice) {
                case 1:
                    this.searchClient();
                    break;
                case 2:
                    this.addNewClient();
            
                default:
                    break;
            }

        } while (choice != 3);

    }

    public void searchClient(){
        Utils.clear();
        System.out.println("--- Recherche de client existant ---\n");
        String nom = Utils.getInput("Entrez le nom du client :\n");

        Optional<Client> clientOpt;
        try {
            clientOpt = this.clientService.findClientByName(nom);
            
            clientOpt.ifPresentOrElse(
                client->{
                    if(client.getNom() !=null){
                        System.out.println("Client trouvé ! \n");
                        System.out.println("Nom : "+ client.getNom());
                        Boolean isValid = false;
                        do {
                            String choice = Utils.getInput("Souhaitez-vous continuer avec ce client ? (y/n) :\n");
                            if(choice.equals("y") || choice.equals("Y") || choice.equals("n") || choice.equals("N")) {
                                isValid = true; 
                                if(choice.equals("y") || choice.equals("Y")){
                                    addNewProjet();
                                }
                            } else {
                                System.out.println("Veuillez entrer Y/y ou n/N");
                            }
                        } while (!isValid);
                    }else{
                        System.out.println("Client n'existe pas avec cet nom !! \n"+nom);
                        return;
                    }
                
    
                    
            }, ()->{
                System.out.println("Client n'existe pas avec cet nom ! \n"+nom);
                return;


            });
        } catch (SQLException e) {
            logger.error("Erreur lors de la recherche du client {}: {}", e.getMessage());

        }

       
        


    }


    public void addNewClient(){
        Utils.clear();
        System.out.println("--- Ajout de nouveau  client  ---\n");
        String nom = Utils.getInput("Entrez le nom du client :\n");
        String adresse = Utils.getInput("Entrez l'addresse de client :\n");
        String telephone = Utils.getInput("Entrez le telephone de client :\n");
        int estProfessionnel;
        Boolean isValid = false;
        do {
            estProfessionnel = Utils.getInputInt("0 - Client régulier | 1 - Client professionnel :\n");
            if(estProfessionnel == 0 || estProfessionnel == 1) {
                isValid = true; 
            } else {
                System.out.println("Veuillez entrer 0 ou 1. \n");
            }
        } while (!isValid);

        Client newClient = new Client();
        newClient.setNom(nom);
        newClient.setAddresse(adresse);
        newClient.setTelephone(telephone);
        if (estProfessionnel == 1) {
            newClient.setEstProfessionnel(true);
        } else {
            newClient.setEstProfessionnel(false);
        }

        try {
            Boolean isAdded = this.clientService.addClient(newClient);
            if(isAdded){
                System.out.println("Client "+ nom + " ajouté avec succès.");
            }else{
                logger.warn("Le client {} n'a pas pu être ajouté.", nom);
            }
        } catch (SQLException e) {
            logger.error("Erreur lors de l'ajout du client {}: {}", nom, e.getMessage());
        }
        




    }


    public void addNewProjet(){
        Utils.clear();
        System.out.println("--- Création d'un Nouveau Projet  ---\n");
        String nom = Utils.getInput("Entrez le nom du projet :\n");
        String surface = Utils.getInput("Entrez la surface de la cuisine  :\n");

        Projet projet = new Projet();
        projet.setNomProjet(nom);


        Utils.clear();
        System.out.println("--- Ajout des composants ---\n");

        Boolean isValid = false;
        String choice ;
        do {
            int choiceMaterial = Utils.getInputInt("Entrez le type de composant 1.Matérial | 2.Main D'oeuvre  :\n");

            if(choiceMaterial == 1) {
                Utils.clear();
                System.out.println("--- Ajout des matériaux ---\n");
                String nomMaterial = Utils.getInput("Entrez le nom du matériau :\n");
                double quantityMaterial = Utils.getInputDouble("Entrez la quantité de ce matériau  :\n");
                double coutUnitaire = Utils.getInputDouble("Entrez le coût unitaire de ce matériau  :\n");
                double coutTransport = Utils.getInputDouble("Entrez le coût de transport de ce matériau   :\n");
                double coefficientQuality = Utils.getInputDouble("Entrez le coefficient de qualité du matériau (1.0 = standard, > 1.0 = haute qualité) :  :\n");


                Material newMaterial = new Material();
                newMaterial.setNom(nomMaterial);
                newMaterial.setTypeComposant("");
                newMaterial.setCoutUnitaire(coutUnitaire);
                newMaterial.setQuantity(quantityMaterial);
                newMaterial.setCoutTransport(coutTransport);
                newMaterial.setCoefficientQualite(coefficientQuality);

                try {
                    Boolean added = this.materialService.addMaterial(newMaterial);
                    if(added){
                        System.out.println("Matériau ajouté avec succès ! \n");
                    }else{
                        logger.warn("Le matérial  {} n'a pas pu être ajouté.", nomMaterial);
                    }
                } catch (SQLException e) {
                    logger.error("Erreur lors de l'ajout de matérial {}: ", e.getMessage());
                }
                

                


            } else if(choiceMaterial ==2) {

                Utils.clear();
                System.out.println("--- Ajout des mains d'oeuvres ---\n");
                String typeMainOeuvre = Utils.getInput("Entrez le type de main-d'œuvre (e.g., Ouvrier de base, Spécialiste) :\n");
                double tauxHoraire = Utils.getInputDouble("Entrez le taux horaire de cette main-d'œuvre (€/h) : :\n");
                double heureTravail = Utils.getInputDouble("Entrez le nombre d'heures travaillées  :\n");
                double productiviteOuvrier = Utils.getInputDouble("Entrez le facteur de productivité (1.0 = standard, > 1.0 = haute productivité) : \n");

                MainOeuvre newMainOeuvre = new MainOeuvre();
                
                newMainOeuvre.setNom(typeMainOeuvre);
                newMainOeuvre.setTypeComposant("");
                newMainOeuvre.setTauxHoraire(tauxHoraire);
                newMainOeuvre.setHeureTravaille(heureTravail);
                newMainOeuvre.setProductiviteOuvrier(productiviteOuvrier);

                try {
                    Boolean added = this.mainOeuvreService.addMainOeuvre(newMainOeuvre);
                    if(added){
                        System.out.println("Main oeuvre ajouté avec succès ! \n");
                    }else{
                        logger.warn("Le main d'oeuvre  {} n'a pas pu être ajouté.", typeMainOeuvre);
                    }
                } catch (SQLException e) {
                    logger.error("Erreur lors de l'ajout de main oeuvre {}: ", e.getMessage());
                }





            }else{
                System.out.println("Veuillez chosir le type de composant 1/2");

            }

            choice = Utils.getInput("Voulez-vous ajouter un autre composant ? (y/n) ?  :\n");
            if(choice.equals("Y") || choice.equals("y"))isValid = false ;else isValid = true;

        } while (!isValid);












    }

   



}
