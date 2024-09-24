package com.baticuisine.service;

import com.baticuisine.Model.Projet;

public interface ProjetService {

    public Projet addNewProjet(Projet projet);
    public Projet getProjectById(Long Id);
    public void getAllProjects();
    public void setCoutTotal(Long Id , double cout_total);
}