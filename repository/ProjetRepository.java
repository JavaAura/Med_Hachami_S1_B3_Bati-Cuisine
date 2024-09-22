package repository;

import Model.MainOeuvre;
import Model.Material;
import Model.Projet;
import java.util.List;

public interface ProjetRepository {
    Projet addProject(Projet projet);
    List<Projet> getAllProjects();
    Projet getProjectById(Long id);
    List<MainOeuvre> getLaborByProjectId(Long projectId);
    List<Material> getMaterialsByProjectId(Long projectId);
}
