package perso.simen.entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnector {
	private static DBConnector instance;
	
	private DBConnector(){}
	
	public static DBConnector getInstance(){
		if(instance==null){
			instance = new DBConnector();
		}
		return instance;
	}
	
	public Connection getConnection() throws ClassNotFoundException, SQLException{
		
		Connection connection= null;
		
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "12345");
		
		return connection;
		
	}
}

//the singleton class will always have one object created within all the life cycle of the application
// how do you make a class singleton, 1- make the constructor private 2- add a method 
//(e.g. getInstance())  to check if we have null reference for this class and if yes, create an object and return