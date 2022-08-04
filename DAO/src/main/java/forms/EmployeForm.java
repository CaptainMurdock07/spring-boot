package forms;

import javax.servlet.http.HttpServletRequest;

import beans.Employe;
import dao.EmployeDao;

public class EmployeForm {
	private String message;
	public void ajouterEmploye(HttpServletRequest request, EmployeDao employeDao) {
		Employe employe = new Employe();
		try {
			employe.setNoEmploye(Integer.parseInt(request.getParameter("noEmploye")));
		} catch (Exception e) {
			this.message = e.getMessage();
		}
		try {
			employe.setSalaire(Double.parseDouble(request.getParameter("salaire")));
		} catch (Exception e) {
			this.message = e.getMessage();
		}
		employe.setNom(request.getParameter("nom"));
		employe.setPrenom(request.getParameter("prenom"));
		employe.setFonction(request.getParameter("fonction"));
		try {
			employeDao.ajouter(employe);
		} catch (Exception e) {
			this.message = e.getMessage();
		}
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
