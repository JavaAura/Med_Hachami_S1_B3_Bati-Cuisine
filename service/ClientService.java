package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import Model.Client;
import Utils.DatabaseConnection;
import repository.ClientRepository;

public class ClientService implements ClientRepository {

    private static Connection con = DatabaseConnection.getConnection();

    @Override
    public Boolean addClient(Client client) throws SQLException {
        if (con == null) {
            throw new SQLException("Database connection is not initialized.");
        }  

        String query = "INSERT INTO Client(nom , adresse, telephone, estProfessionnel) VALUES (?,?,?,?)";
        PreparedStatement ps=null;
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, client.getNom());
            ps.setString(2, client.getAdresse());
            ps.setString(3, client.getTelephone());
            ps.setBoolean(4, client.getEstProfessionnel());


            int n = ps.executeUpdate();
            

            return n ==1;


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

        return false; 

    }

    @Override
    public Optional<Client> findClientByName(String nom) throws SQLException {
        Client client = new Client();
        if (con == null) {
            throw new SQLException("Database connection is not initialized.");
        }  


        String query1 = "SELECT * from Client WHERE nom LIKE ?   ";
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(query1);
            ps.setString(1,"%"+nom+"%");
            rs = ps.executeQuery();
            while (rs.next()) {
                client.setId(rs.getLong("id"));
                client.setNom(rs.getString("nom"));
                client.setAddresse(rs.getString("adresse"));
                client.setTelephone(rs.getString("telephone"));
                client.setEstProfessionnel(rs.getBoolean("estProfessionnel"));

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
        return Optional.ofNullable(client); 
    }
    
}
