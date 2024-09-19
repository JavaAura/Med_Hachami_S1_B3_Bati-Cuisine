package service;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import Model.Material;
import Utils.DatabaseConnection;
import repository.MaterialRepository;

public class MaterialService implements MaterialRepository {

    private static Connection con = DatabaseConnection.getConnection();

    @Override
    public Boolean addMaterial(Material material) throws SQLException {
        if (con == null) {
            throw new SQLException("Database connection is not initialized.");
        }  

        String query = "INSERT INTO  Material (nom , typecomposant , coutunitaire , quantity , couttransport , coefficientqualite) VALUES(? , ? , ? , ? , ? , ?)";
        PreparedStatement ps = null;

        try {
        
            ps = con.prepareStatement(query);
            ps.setString(1, material.getNom());
            ps.setString(2, "Material");
            ps.setDouble(3, material.getCoutUnitaire());
            ps.setDouble(4, material.getQuantity());
            ps.setDouble(5, material.getCoutTransport());
            ps.setDouble(6, material.getCoefficientQualite());
            


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
