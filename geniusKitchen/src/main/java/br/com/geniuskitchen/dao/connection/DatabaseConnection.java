package br.com.geniuskitchen.dao.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	
    private static DatabaseConnection instance = null;
    private Connection connection = null;

    private DatabaseConnection() {
        try {
        	
            connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            
        } catch (Exception ex) {
        	
            System.err.println(ex.getMessage());
        }
    }

    public static DatabaseConnection getInstance() {
    	
        if (instance == null) {
        	
            instance = new DatabaseConnection();
            
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
