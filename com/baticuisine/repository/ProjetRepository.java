package com.baticuisine.repository;

import java.util.List;
import java.util.Optional;

import com.baticuisine.Model.MainOeuvre;
import com.baticuisine.Model.Material;
import com.baticuisine.Model.Projet;

public interface ProjetRepository {
    Projet addProject(Projet projet);
    List<Projet> getAllProjects();
    Optional<Projet> getProjectById(Long id);
    List<MainOeuvre> getLaborByProjectId(Long projectId);
    List<Material> getMaterialsByProjectId(Long projectId);
    Boolean updateCoutTotal(Long Id , double cout_total);
}
