package com.baticuisine.repository.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.baticuisine.Enum.TypeComposant;
import com.baticuisine.Model.Material;
import com.baticuisine.Utils.DatabaseConnection;
import com.baticuisine.repository.MaterialRepository;

public class MaterialRepositoryImpl implements MaterialRepository {
    
    private static Connection con = DatabaseConnection.getConnection();
    private static final Logger logger = LoggerFactory.getLogger(MaterialRepositoryImpl.class);

    @Override
    public Boolean addMaterial(Material material)  {
        if (con == null) {
            logger.error("database connection is not set");
            
        }  

        String query = "INSERT INTO  materiel (nom , type_composant ,taux_tva,projet_id , cout_unitaire , quantite , cout_transport , coefficient_qualite ) VALUES(? , ?::typecomposant , ? , ? , ? , ? , ? , ?)";
        PreparedStatement ps = null;

        try {
        
            ps = con.prepareStatement(query);
            ps.setString(1, material.getNom());
            ps.setString(2, TypeComposant.materiel.name());
            ps.setDouble(3, material.getTauxTVA());
            ps.setLong(4, material.getProjetId());
            ps.setDouble(5, material.getCoutUnitaire());
            ps.setDouble(6, material.getQuantity());
            ps.setDouble(7, material.getCoutTransport());
            ps.setDouble(8, material.getCoefficientQualite());

            
            


            int n = ps.executeUpdate();
            return n==1;

        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
