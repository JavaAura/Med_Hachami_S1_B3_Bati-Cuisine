package repository.Impl;

import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Connection;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Enum.TypeComposant;
import Model.MainOeuvre;
import Utils.DatabaseConnection;
import repository.MainOeuvreRepository;

public class MainOeuvreRepositoryImpl implements MainOeuvreRepository {

    private static Connection con = DatabaseConnection.getConnection();
    private static final Logger logger = LoggerFactory.getLogger(MainOeuvreRepositoryImpl.class);

    @Override
    public Boolean addMainOeuvre(MainOeuvre mainOeuvre)  {
       

        String query = "INSERT INTO  labor (nom , type_composant ,taux_tva , projet_id  , taux_horaire , heures_travail , productivite_ouvrier) VALUES(? , ?::typecomposant , ? , ? , ? , ? ,?)";
        PreparedStatement ps = null;

        try {
        
            ps = con.prepareStatement(query);
            ps.setString(1, mainOeuvre.getNom());
            ps.setString(2,TypeComposant.labor.name());
            ps.setDouble(3, mainOeuvre.getTauxTVA());
            ps.setLong(4, mainOeuvre.getProjetId());
            ps.setDouble(5, mainOeuvre.getTauxHoraire());
            ps.setDouble(6, mainOeuvre.getHeureTravail());
            ps.setDouble(7, mainOeuvre.getProductiviteOuvrier());
            

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
