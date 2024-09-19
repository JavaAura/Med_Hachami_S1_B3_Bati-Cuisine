package service;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;


import Model.MainOeuvre;
import Utils.DatabaseConnection;
import repository.MainOeuvreRepository;

public class MainOeuvreService implements MainOeuvreRepository{

    private static Connection con = DatabaseConnection.getConnection();

    @Override
    public Boolean addMainOeuvre(MainOeuvre mainOeuvre) throws SQLException {
        if (con == null) {
            throw new SQLException("Database connection is not initialized.");
        }  

        String query = "INSERT INTO  MainOeuvre (nom , typecomposant , tauxhoraire , heuretravail , productiviteouvrier) VALUES(? , ? , ? , ? , ?)";
        PreparedStatement ps = null;

        try {
        
            ps = con.prepareStatement(query);
            ps.setString(1, mainOeuvre.getNom());
            ps.setString(2, "MainOeuvre");
            ps.setDouble(3, mainOeuvre.getTauxHoraire());
            ps.setDouble(4, mainOeuvre.getHeureTravail());
            ps.setDouble(5, mainOeuvre.getProductiviteOuvrier());


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
