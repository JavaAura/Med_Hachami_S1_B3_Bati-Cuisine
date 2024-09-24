package com.baticuisine.service.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

import com.baticuisine.Model.Projet;
import com.baticuisine.Utils.Utils;
import com.baticuisine.repository.ProjetRepository;
import com.baticuisine.repository.Impl.ProjetRepositoryImpl;
import com.baticuisine.service.ProjetService;

public class ProjetServiceImpl implements ProjetService {
    private static final Logger logger = LoggerFactory.getLogger(ProjetServiceImpl.class);

    final ProjetRepository projetRepository ;

    public ProjetServiceImpl(ProjetRepositoryImpl projetRepositoryImpl){
        this.projetRepository = projetRepositoryImpl;
    }

    @Override
    public Projet addNewProjet(Projet projet) {
        Projet addedProject =  this.projetRepository.addProject(projet);
        if(addedProject != null){
            System.out.println("Le projet à été ajouté");
            return addedProject;
        }else{
            logger.error("error in adding project ");
            return null;
        }

    }

    @Override
    public void getAllProjects() {
        List<Projet>  projets = this.projetRepository.getAllProjects();

        if (projets.isEmpty()) {
            System.out.println("Aucun projet trouvé.");
        } 
        else
        {
            System.out.println("--- Project Details ---");

            projets.stream()
                .forEach(projet -> {
                    System.out.println("Nom du Projet : " + projet.getNomProjet());
                    // System.out.println("Client : " + projet.getClient().getNom()); 
                    System.out.println("Marge Bénéficiaire : " + projet.getMargeBeneficiaire() + "%");
                    System.out.println("État du Projet : " + projet.getEtatProjet());
                    System.out.println("--- Fin de Projet ---\n");
                });

        }
    }

    public Projet getProjectById(Long Id){
        Optional<Projet> projeOptional =  this.projetRepository.getProjectById(Id);

        if(projeOptional.isPresent()){
            return projeOptional.get();
        }else{
            logger.error("No project found with the id {}", Id);
            return null;
        }
    }

    @Override
    public void setCoutTotal(Long Id, double cout_total) {
        Optional<Projet> projeOptional =  this.projetRepository.getProjectById(Id);
        if(projeOptional.isPresent()){
            this.projetRepository.updateCoutTotal(Id, cout_total);

        }

    }


    
}
