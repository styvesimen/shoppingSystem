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

