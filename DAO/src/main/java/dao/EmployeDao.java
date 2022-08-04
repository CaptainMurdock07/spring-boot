package dao;

import java.util.List;
import beans.Employe;

public interface EmployeDao {

	void ajouter(Employe employe);
	Employe lire(int noEmploye);
	List<Employe> lister();
	void modifier(Employe employe);
	void supprimer(int noEmploye);
}
