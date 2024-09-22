package service;

import Model.Projet;

public interface ProjetService {

    public Projet addNewProjet(Projet projet);
    public Projet getProjectById(Long Id);
    public void getAllProjects();
}