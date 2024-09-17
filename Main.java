
import java.sql.Connection;
import java.sql.SQLException;

import Utils.DatabaseConnection;
public class Main {
     public static void main(String[] args) throws SQLException{

       Connection con = DatabaseConnection.getConnection();
       if (con == null) {
            throw new SQLException("Database connection is not initialized.");
        }

      System.out.println("Hello world");

    }

}
