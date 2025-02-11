package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
	
    public static void main(String[] args) {
		
	    String url = "jdbc:mysql://localhost:3306/music";
	    String username = "DevJava";
	    String password = "DevJava";
	    System.out.println("Step1");
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        ResultSet rows = null;
	    System.out.println("Step2");
	    try {
	    	connection = DriverManager.getConnection(url, username, password);
	    	System.out.println("Connection to MySQL database successful!");
	    	 
	    	 
	        // 3. Create a Statement object to execute queries
            statement = connection.createStatement();

            // 4. Execute the query to get all tables in the current database
            String query = "SHOW TABLES";
            resultSet = statement.executeQuery(query);

            // 5. Process the result set and print table names
            System.out.println("Tables in the database:");
            while (resultSet.next()) {
                String tableName = resultSet.getString(1); 
                System.out.println(tableName);
//                String query2 = "Select count(*) from " + tableName;
//                
//                rows = statement.executeQuery("Select count(*) from " + tableName);
//                System.out.println(tableName);
//                System.out.println(query2);
//                System.out.println(rows);
            } 
	    	 
	    	 
//	    } catch (ClassNotFoundException e) {
//            System.out.println("MySQL JDBC driver not found.");
//            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                	System.out.println("I am here.");
                    connection.close();
                }
            } catch (SQLException e) {
            	System.out.println("I am here 2.");
            	e.printStackTrace();
                
            }
        }
	    	
	    	
	    System.out.println("Hello, World!");
    	
    	System.out.println("url:" + url + "\n"
    			+ "username:" + username + "\n"
    			+ "password:" + password + "\n"
    			);
    	
    	
    }
}
	
