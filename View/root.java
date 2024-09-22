package View;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.helpers.Util;

import Model.Client;
import Model.Composant;
import Model.MainOeuvre;
import Model.Material;
import Model.Projet;
import Utils.Utils;
import service.ClientService;
import service.MainOeuvreService;
import service.MaterialService;
import service.ProjetService;

public class root {

    private static final Logger logger = LoggerFactory.getLogger(root.class);

    final ClientService clientService;
    final MaterialService materialService;
    final MainOeuvreService mainOeuvreService;
    final ProjetService projetService;

    public root(ClientService clientService , MaterialService materialService,MainOeuvreService mainOeuvreService , ProjetService projetService){
        this.clientService = clientService;
        this.materialService = materialService;
        this.mainOeuvreService = mainOeuvreService;
        this.projetService = projetService;
    }




    public void showMenu(){
        int choice = 0;
        
        do {
            // Utils.clear();
            System.out.println("=== Bienvenue dans l'application de gestion des projets de rénovation de cuisines === \n"); 
            System.out.println("=== Menu Principal ===");
    
            System.out.println("1. Créer un nouveau projet");
            System.out.println("2. Afficher les projets existants");
            System.out.println("3. Calculer le coût d'un projet");
            System.out.println("4. Quitter");
            choice = Utils.getInputInt("Choisissez une option :");
    
            switch (choice) {
                case 1:
                    showSubMenu();
                    break;
                case 2:
                     Utils.clear();
                    this.projetService.getAllProjects();
                
                break;
                case 3:
                calculerCoutTotal();
                
                    break;  
            
                default:
                    break;
            }
    
    
            
        } while (choice != 4);
    }

    public void showSubMenu(){
        int choice = 0;

        do {
            // Utils.clear();

            System.out.println("=== Recherche client ===");
            System.out.println("Souhaitez-vous chercher un client existant ou en ajouter un nouveau ?");
            System.out.println("1. Chercher un client existant");
            System.out.println("2. Ajouter un nouveau client");
            System.out.println("3. Quitter");


            choice = Utils.getInputInt("Choisissez une option :\n");

            switch (choice) {
                case 1:
                    searchClient();
                    break;
                case 2:
                    addNewClient();
            
                default:
                    break;
            }

        } while (choice != 3);

    }

    public void searchClient(){
        // Utils.clear();
        System.out.println("--- Recherche de client existant ---\n");
        String nom = Utils.getInput("Entrez le nom du client :\n");

        Optional<Client> clientOpt = this.clientService.findClientByName(nom);
            
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
                                addNewProjet(client);
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

    }


    public void addNewClient(){
        // Utils.clear();
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

        this.clientService.addClient(newClient);
    }


    public void addNewProjet(Client client){
        // Utils.clear();
        System.out.println("clien nom"+client.getNom());
        System.out.println("clien id"+client.getTelephone());

        System.out.println("--- Création d'un Nouveau Projet  ---\n");
        String nom = Utils.getInput("Entrez le nom du projet :\n");
        String surface = Utils.getInput("Entrez la surface de la cuisine  :\n");


        Projet projet = new Projet();
        projet.setNomProjet(nom);


        Utils.clear();
        System.out.println("--- Ajout des composants ---\n");

        Boolean isValid = false;
        String choice ;
        List<MainOeuvre> labors = new ArrayList<>();
        List<Material> materiels = new ArrayList<>();

        do {
            int choiceMaterial = Utils.getInputInt("Entrez le type de composant 1.Matérial | 2.Main D'oeuvre  :\n");

            if(choiceMaterial == 1) {
                Utils.clear();
                System.out.println("--- Ajout des matériaux ---\n");
                String nomMaterial = Utils.getInput("Entrez le nom du matériau :\n");
                double quantityMaterial = Utils.getInputDouble("Entrez la quantité de ce matériau  :\n");
                double tauxTVA = Utils.getInputDouble("Entre le tva % pour ce composant");
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
                newMaterial.setTauxTVA(tauxTVA);

                materiels.add(newMaterial);

            } else if(choiceMaterial ==2) {

                Utils.clear();
                System.out.println("--- Ajout des mains d'oeuvres ---\n");
                String typeMainOeuvre = Utils.getInput("Entrez le type de main-d'œuvre (e.g., Ouvrier de base, Spécialiste) :\n");
                double tauxHoraire = Utils.getInputDouble("Entrez le taux horaire de cette main-d'œuvre (€/h) : :\n");
                double tauxTVA = Utils.getInputDouble("Entre le tva % pour ce composant");
                double heureTravail = Utils.getInputDouble("Entrez le nombre d'heures travaillées  :\n");
                double productiviteOuvrier = Utils.getInputDouble("Entrez le facteur de productivité (1.0 = standard, > 1.0 = haute productivité) : \n");

                MainOeuvre newMainOeuvre = new MainOeuvre();
                
                newMainOeuvre.setNom(typeMainOeuvre);
                newMainOeuvre.setTypeComposant("");
                newMainOeuvre.setTauxHoraire(tauxHoraire);
                newMainOeuvre.setHeureTravail(heureTravail);
                newMainOeuvre.setProductiviteOuvrier(productiviteOuvrier);
                newMainOeuvre.setTauxTVA(tauxTVA);

                labors.add(newMainOeuvre);
            
            }else{
                System.out.println("Veuillez chosir le type de composant 1/2");

            }

            choice = Utils.getInput("Voulez-vous ajouter un autre composant ? (y/n) ?  :\n");
            if(choice.equals("Y") || choice.equals("y"))isValid = false ;else isValid = true;

            



        } while (!isValid);



        boolean appliquerMarge = false;
        String appliquerMargeInput = Utils.getInput("Souhaitez-vous appliquer une marge bénéficiaire au projet ? (y/n) :\n");
        if (appliquerMargeInput.equalsIgnoreCase("y")) {
            appliquerMarge = true;
        }
        double margeBeneficiaire = 0;
        if (appliquerMarge) {
            margeBeneficiaire = Utils.getInputDouble("Entrez le pourcentage de marge bénéficiaire (%) :\n");
        }


        projet.setMargeBeneficiaire(margeBeneficiaire);

        projet.setClient(client);


        Long projectId = this.projetService.addNewProjet(projet).getId();

        for (Material material : materiels) {
            material.setProjetId(projectId); 
            Boolean addedMaterial = this.materialService.addMaterial(material);
            if (addedMaterial) {
                System.out.println("Matériau ajouté avec succès : " + material.getNom());
            } else {
                logger.warn("The material {} could not be added.", material.getNom());
            }
        }
        
        for (MainOeuvre mainOeuvre : labors) {
            mainOeuvre.setProjetId(projectId);
            Boolean addedLabor = this.mainOeuvreService.addMainOeuvre(mainOeuvre);
            if (addedLabor) {
                System.out.println("Main ouevre ajouté avec succès : " + mainOeuvre.getNom());
            } else {
                logger.warn("The labor {} could not be added.", mainOeuvre.getNom());
            }
        }

    }

    public void calculerCoutTotal(){
        Utils.clear();
        System.out.println("Calcul du coût en cours...");


        
        Long projectId = (long)Utils.getInputInt("\"Entrer l'id de projet");

        Projet projet =  this.projetService.getProjectById(projectId);

       if(projet == null){
            System.out.println("Le projet avec "+ projectId+" n existe pas");
            return;
       }
        System.out.println("--- Résultat du Calcul ---");
        System.out.println("Nom du projet : " + projet.getNomProjet());
        System.out.println("Client : " + projet.getClient().getNom());
        System.out.println("Adresse du chantier : " + projet.getClient().getAdresse()); 




   // Assuming surface is part of Projet

    // // Materials
    System.out.println("--- Détail des Coûts ---");
    System.out.println("1. Matériaux :");
    
    double totalMaterialsBeforeVAT = 0;
    double totalMaterialsWithVAT = 0;

    for (Material material : projet.getMaterials()) {
        double costBeforeVAT = material.calculerCoutAvantTVA();
        double costWithVAT = material.calculerCoutAvecTVA(costBeforeVAT);
        




        totalMaterialsBeforeVAT += costBeforeVAT;
        totalMaterialsWithVAT += costWithVAT;

        System.out.printf("- %s : %.2f € (quantité : %.2f, coût unitaire : %.2f €/m², qualité : %.2f, transport : %.2f €)%n%n",
                material.getNom(), costWithVAT, material.getQuantity(), material.getCoutUnitaire(), material.getCoefficientQualite(), material.getCoutTransport());
    }

    System.out.printf("**Coût total des matériaux avant TVA : %.2f €**%n", totalMaterialsBeforeVAT);
    System.out.printf("**Coût total des matériaux avec TVA  : %.2f €**%n", totalMaterialsWithVAT);

    // Labor
    System.out.println("2. Main-d'œuvre :");
    
    double totalLaborBeforeVAT = 0;
    double totalLaborWithVAT = 0;

    for (MainOeuvre labor : projet.getLabors()) {
        double costBeforeVAT = labor.calculerCoutAvantTVA();
        double costWithVAT = labor.calculerCoutAvecTVA(costBeforeVAT);

        totalLaborBeforeVAT += costBeforeVAT;
        totalLaborWithVAT += costWithVAT;

        System.out.printf("- %s : %.2f € (taux horaire : %.2f €/h, heures travaillées : %.2f h, productivité : %.2f)%n",
                labor.getNom(), costWithVAT, labor.getTauxHoraire(), labor.getHeureTravail(), labor.getProductiviteOuvrier());
    }

    System.out.printf("**Coût total de la main-d'œuvre avant TVA : %.2f €**%n", totalLaborBeforeVAT);
    System.out.printf("**Coût total de la main-d'œuvre avec TVA : %.2f €**%n", totalLaborWithVAT);

    // Total Costs
    double totalCostBeforeMargin = totalMaterialsBeforeVAT + totalLaborBeforeVAT;
    double margin = projet.getMargeBeneficiaire() / 100 * totalCostBeforeMargin;
    double finalCost = totalCostBeforeMargin + margin;

    System.out.printf("3. Coût total avant marge : %.2f €%n", totalCostBeforeMargin);
    System.out.printf("4. Marge bénéficiaire (%.2f%%) : %.2f €%n", projet.getMargeBeneficiaire(), margin);
    System.out.printf("**Coût total final du projet : %.2f €**%n", finalCost);

        


    }

}
