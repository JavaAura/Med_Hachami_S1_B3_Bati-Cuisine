package com.baticuisine.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// import src.com.baticuisine.service.Impl.ProjetServiceImpl;

public class DatabaseConnection {
    private static Connection connection = null;
        private static final Logger logger = LoggerFactory.getLogger(DatabaseConnection.class);


    static {
    
       

        final String DB_URL = EnvLoader.getEnvVar("DB_URL");
        final String DB_USERNAME = EnvLoader.getEnvVar("DB_USERNAME");
        final String DB_PASSWORD = EnvLoader.getEnvVar("DB_PASSWORD");


        try {
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            // logger.info("Connected to the database.");

            System.out.println("");
        }catch (SQLException e) {
            logger.error("Connection failed. Check output console for more details.", e);
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
