import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MySQLConnection {

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

}
