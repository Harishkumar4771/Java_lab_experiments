package experiment_9;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class SQLCon {
    private static Properties env = new Properties();
    private static final String DB_URL = "jdbc:mysql://Bs-Laptop.local:3306/FoodieDB";

    static {
        try {
            // Registering the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Loading the file from the experiment_9 folder
            try (FileInputStream fis = new FileInputStream("experiment_9/.env")) {
                env.load(fis);
            }
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("File Error: " + e.getMessage());
        }
    }

    public static Connection getConnection() throws SQLException {
        String password = env.getProperty("passwd");
        // Change "Root" to "root"
        return DriverManager.getConnection(DB_URL, "root", password);
    }
}