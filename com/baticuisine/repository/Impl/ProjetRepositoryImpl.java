package com.baticuisine.repository.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;
import java.util.Optional;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.baticuisine.Enum.StatutProject;
import com.baticuisine.Model.Client;
import com.baticuisine.Model.MainOeuvre;
import com.baticuisine.Model.Material;
import com.baticuisine.Model.Projet;
import com.baticuisine.Utils.DatabaseConnection;
import com.baticuisine.repository.ProjetRepository;


public class ProjetRepositoryImpl implements ProjetRepository {

    private static Connection con = DatabaseConnection.getConnection();
    private static final Logger logger = LoggerFactory.getLogger(ProjetRepositoryImpl.class);

    @Override
    public Projet addProject(Projet projet) {
        if (con == null) {
            logger.error("Database connection is not set");
            return null;
        }
        
        String query = "INSERT INTO projects(name, marge_beneficiaire, client_id) VALUES (?, ?, ?)";
        PreparedStatement ps = null;
    
        try {
            ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            
            ps.setString(1, projet.getNomProjet()); 
            ps.setDouble(2, projet.getMargeBeneficiaire()); 
            ps.setLong(3, projet.getClient().getId());
    
            int n = ps.executeUpdate();
            
            if (n == 1) {
                ResultSet generatedKeys = ps.getGeneratedKeys();
                if (generatedKeys.next()) {
                    Long generatedId = generatedKeys.getLong(1); 
                    projet.setId(generatedId); 
                    return projet; 
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    
        return null; 
    }
    

    @Override
    public List<Projet> getAllProjects() {
        List<Projet> projets = new ArrayList<>();

         String query = "SELECT * FROM projects";

        try (Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Projet projet = new Projet();
                projet.setNomProjet(rs.getString("name"));
                projet.setMargeBeneficiaire(rs.getDouble("marge_beneficiaire"));
                projet.setEtatProjet(StatutProject.valueOf(rs.getString("etat_projet")));
                projet.setCoutTotal(rs.getDouble("cout_total"));
                projet.setCoutTotal(rs.getDouble("marge_beneficiaire"));


                
                projets.add(projet);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return projets;
    }


    @Override
    public Optional<Projet>  getProjectById(Long id) {
        Projet projet = null;
        String query = "SELECT p.*, c.nom AS client_name, c.adresse AS client_adresse "
                    + "FROM projects p "
                    + "JOIN client c ON p.client_id = c.id "
                    + "WHERE p.id = ?";

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(query);
            ps.setLong(1, id);

            rs = ps.executeQuery();

            if (rs.next()) {
                projet = new Projet();
                projet.setId(rs.getLong("id"));
                projet.setNomProjet(rs.getString("name"));
                projet.setMargeBeneficiaire(rs.getDouble("marge_beneficiaire"));
                projet.setEtatProjet(StatutProject.valueOf(rs.getString("etat_projet")));
                projet.setCoutTotal(rs.getDouble("cout_total"));

                Client client = new Client();
                client.setNom(rs.getString("client_name"));
                client.setAddresse(rs.getString("client_adresse"));
                projet.setClient(client);

                projet.setMaterials(getMaterialsByProjectId(id));
                projet.setLabors(getLaborByProjectId(id));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return Optional.ofNullable(projet); 

    }

    public List<Material> getMaterialsByProjectId(Long projectId) {
        List<Material> materials = new ArrayList<>();
        String query = "SELECT * FROM materiel WHERE projet_id = ?";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setLong(1, projectId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Material material = new Material();
                material.setNom(rs.getString("nom"));
                material.setTauxTVA(rs.getDouble("taux_tva"));
                material.setQuantity(rs.getDouble("quantite"));
                material.setCoutUnitaire(rs.getDouble("cout_unitaire"));
                material.setCoutTransport(rs.getDouble("cout_transport"));
                material.setCoefficientQualite(rs.getDouble("coefficient_qualite"));
                materials.add(material);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return materials;
    }

    public List<MainOeuvre> getLaborByProjectId(Long projectId) {
        List<MainOeuvre> labors = new ArrayList<>();
        String query = "SELECT * FROM labor WHERE projet_id = ?";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setLong(1, projectId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                MainOeuvre labor = new MainOeuvre();
                labor.setNom(rs.getString("nom"));
                labor.setTauxTVA(rs.getDouble("taux_tva"));
                labor.setTauxHoraire(rs.getDouble("taux_horaire"));
                labor.setHeureTravail(rs.getDouble("heures_travail"));
                labor.setProductiviteOuvrier(rs.getDouble("productivite_ouvrier"));
                labors.add(labor);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return labors;
    }


    @Override
    public Boolean updateCoutTotal(Long Id,double cout_total) {
        if (con == null) {
            logger.error("Database connection is not set");
            return null;
        }

        String query = "UPDATE projects SET cout_total = ? WHERE id = ?";
        PreparedStatement ps=null;


        try {
            ps = con.prepareStatement(query);
            ps.setDouble(1, cout_total);
            ps.setLong(2, Id);

           return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            logger.error("Error : updating project cout_total" ,e);
            return null;
        }
    }
    
}
