package service.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import Model.Projet;
import repository.ProjetRepository;
import service.ProjetService;

public class ProjetServiceImpl implements ProjetService {
    private static final Logger logger = LoggerFactory.getLogger(ProjetServiceImpl.class);

    final ProjetRepository projetRepository ;

    public ProjetServiceImpl(ProjetRepository projetRepository){
        this.projetRepository = projetRepository;
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
       return this.projetRepository.getProjectById(Id);
    }


    
}
