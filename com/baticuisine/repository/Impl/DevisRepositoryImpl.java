package com.baticuisine.repository.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.baticuisine.Model.Devis;
import com.baticuisine.Utils.DatabaseConnection;
import com.baticuisine.repository.DevisRepository;

public class DevisRepositoryImpl implements DevisRepository {

    private static Connection con = DatabaseConnection.getConnection();
    private static final Logger logger = LoggerFactory.getLogger(DevisRepositoryImpl.class);
   
    @Override
    public Boolean addDevis(Devis devis) {
        if (con == null) {
            logger.error("database connection is not set");
            return false;
        }  

        String query = "INSERT INTO devis(montant_estime,date_emission,date_validite,accepte , projet_id) VALUES(? , ? ,? , ? ,?)";
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(query);
            ps.setDouble(1, devis.getMontantEstime());
            ps.setDate(2, new java.sql.Date(devis.getDateEmission().getTime()));
            ps.setDate(3, new java.sql.Date(devis.getDateValidite().getTime()));
            ps.setBoolean(4, devis.isAccepte());
            ps.setLong(5, devis.getProjet().getId());

            int n = ps.executeUpdate();

            return n ==1;

        } catch (SQLException e) {
            logger.error("Error inserting the devis " ,e);
            return false;
        }
    }
    
}
