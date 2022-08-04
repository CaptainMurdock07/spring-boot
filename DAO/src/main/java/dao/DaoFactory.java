package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoFactory {
	private String url;
	private String username;
	private String password;
	
	public DaoFactory(String url, String username, String password) {
		super();
		this.url = url;
		this.username = username;
		this.password = password;
	}
	
	public static DaoFactory getInstance() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			
		}
		DaoFactory instance = new DaoFactory("jdbc:oracle:thin:@localhost:1521:xe","la300","secret");
		return instance;
	}
	
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}
	
	// Récupération du DAO de chaque ensemble de données
	public EmployeDao getEmployeDao() {
		return new EmployeDaoImpl(this);
	}
	
}
