package Utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class EnvLoader {
    private static final Map<String, String> envVars = new HashMap<>();

    static {
        try {
            File envFile = new File(".env"); 
            BufferedReader reader = new BufferedReader(new FileReader(envFile));

            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().startsWith("#") && line.contains("=")) {
                    String[] keyValue = line.split("=", 2);
                    envVars.put(keyValue[0].trim(), keyValue[1].trim());
                }
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Error loading .env file: " + e.getMessage());
        }
    }

    public static String getEnvVar(String key) {
        return envVars.get(key);
    }
}
