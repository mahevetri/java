package jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public static final String url="jdbc:mysql:localhost:3306/sakila";
	public static final String userName="root";
	public static final String pswd="pass@word2";
	
	public static Connection getConnection() {

		// DriverManager.registerDriver(null);
		try {
			Driver driver= new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(driver);
		     return DriverManager.getConnection(url, userName, pswd);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("Error Connecting to database");
		}

	}
	public static void main(String args[]) {
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connection connection=ConnectionFactory.getConnection();
		if(connection != null) {
			System.out.println("Connected to database");
		}
		else {
			System.out.println("Failed to make Connection to database");
		}
	}

}
