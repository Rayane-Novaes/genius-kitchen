package br.com.geniuskitchen.dao.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	
    private static DatabaseConnection instance = null;
    private Connection conn = null;

    private DatabaseConnection() {
        
    	try {
    		
            conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            
        } catch (Exception ex) {
        	
            System.err.println("\n" + ex.getMessage());
            
        }
    }

    public static DatabaseConnection getInstance() {
        
    	if (instance == null) {
    		
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return conn;
    }
}

