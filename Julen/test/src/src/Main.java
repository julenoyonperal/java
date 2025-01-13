package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
	
	public static Connection CreateConnection() {
		
	    String url = "jdbc:mysql://localhost:3306/music";
	    String username = "DevJava";
	    String password = "DevJava";
	    Connection connection = null;
	    try {
	    	connection = DriverManager.getConnection(url, username, password);
	    } catch (SQLException e) {
	            System.out.println("Connection failed!");
	            e.printStackTrace();
	     }
	    
        if (connection != null) {
            System.out.println("Connection successful!");
        } else {
            System.out.println("Connection failed.");
        }
        
	    return connection;
	}
	
	public static void main(String[] arg) {
		Connection connection = CreateConnection();

	}
}
	
 