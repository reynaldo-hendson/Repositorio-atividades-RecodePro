package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {
	
	private static final String URL = "jdbc:mysql://localhost:3306/java_crud";
	private static final String USER = "root";
	private static final String PASSWORD = "20021986rey#R";
	
	//Retorna a conexao  com mysql
	public static Connection  createConnection() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Found.");
		}catch(ClassNotFoundException e) {
			System.out.println("Driver not found" + e.getMessage());
			
		}
		
		try {
			Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
			System.out.println("Connected to database");
			return connection;
			
		}catch(SQLException e){
			System.out.println("Not connected to database" + e.getMessage());
			return null;
			
		}
		
	}
	
		

}
