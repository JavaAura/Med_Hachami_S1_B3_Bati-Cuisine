package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection connection = null;

    static {
    
        // Access environment variables
        // String url = "jdbc:postgresql://localhost:5432/booktrack";
        // String user = "root";
        // String pass = "root";

        final String DB_URL = EnvLoader.getEnvVar("DB_URL");
        final String DB_USERNAME = EnvLoader.getEnvVar("DB_USERNAME");
        final String DB_PASSWORD = EnvLoader.getEnvVar("DB_PASSWORD");


        try {
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            System.out.println("Connected to the database.");
        }catch (SQLException e) {
            System.out.println("Connection failed. Check output console for more details.");
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
