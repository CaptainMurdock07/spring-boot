package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Employe;

public class EmployeDaoImpl implements EmployeDao {
	
	private DaoFactory daoFactory;
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	EmployeDaoImpl(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void ajouter(Employe employe) {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		try {
			connexion = daoFactory.getConnection();
			preparedStatement = connexion.prepareStatement(
				"INSERT INTO EMPLOYES (NO_EMPLOYE, NOM, PRENOM,FONCTION,SALAIRE) "
				+ "VALUES (?,?,?,?,?)");
			preparedStatement.setInt(1, employe.getNoEmploye());
			preparedStatement.setString(2, employe.getNom());
			preparedStatement.setString(3, employe.getPrenom());
			preparedStatement.setString(4, employe.getFonction());
			preparedStatement.setDouble(5, employe.getSalaire());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			this.message = e.getMessage();
		}
		
	}

	@Override
	public Employe lire(int noEmploye) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employe> lister() {
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		List<Employe> employes = new ArrayList<Employe>();
		
		try {
			connection = daoFactory.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery("SELECT * FROM EMPLOYES");
			while (rs.next()) {
				int noEmploye = rs.getInt("NO_EMPLOYE");
				String nom = rs.getString("NOM");
				String prenom = rs.getString("PRENOM");
				String fonction = rs.getString("FONCTION");
				double salaire = rs.getDouble("SALAIRE");
				
				Employe employe = new Employe();
				employe.setNoEmploye(noEmploye);
				employe.setNom(nom);
				employe.setPrenom(prenom);
				employe.setFonction(fonction);
				employe.setSalaire(salaire);
				
				employes.add(employe);
			}
		} catch (SQLException e) {
			this.message = e.getMessage();
		} 
		return employes;
	}

	@Override
	public void modifier(Employe employe) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimer(int noEmploye) {
		// TODO Auto-generated method stub
		
	}

}
