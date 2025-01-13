import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Main {

	public static void main(String[] args) throws SQLException {
	
		Connection mysql = MySQLConnection.CreateConnection();
				
        java.sql.Statement statement = null;
        ResultSet resultSet = null;
        System.out.println("Step2");
        int iteration = 0;
	    
        try {
    	 
	        // 3. Create a Statement object to execute queries
            statement = mysql.createStatement();

            // 4. Execute the query to get all tables in the current database
            String query = "SHOW TABLES";
            resultSet = statement.executeQuery(query);

            // 5. Process the result set and print table names
            System.out.println("Tables in the database:");
            while (resultSet.next()) {
            	iteration = iteration + 1;
                String tableName = resultSet.getString(1); 
                String tableNameFull = iteration + " - " + tableName;
                System.out.println(tableNameFull);
            } 
        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
        
        System.out.println("Start of the Insert Query");
        
        String query2 = "INSERT INTO music.albums (album_id, album_name, artist_id)" +
        	" VALUES (9827, 'The Dark Side of the Moon', 101);";
        
        System.out.println(query2);
    	
        statement.execute(query2);

	    	
	    System.out.println("End of the Insert Query");
    	
    	
    	
    	
	}

}
