package com.example.demo.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Formation {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
	private Integer id;
	/*
	 * private int idCategorie; private int idFormateur; private int duree; private
	 * Date dateDebut; private double prix; private String lieux; private String
	 * descriptif; private String lienTest; private int idNiveau;
	 */
	private String nom;
	
	public Formation() {
		super();
	}

	public Formation(Integer id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	/*
	 * public int getIdCategorie() { return idCategorie; }
	 * 
	 * public void setIdCategorie(int idCategorie) { this.idCategorie = idCategorie;
	 * }
	 * 
	 * public int getIdFormateur() { return idFormateur; }
	 * 
	 * public void setIdFormateur(int idFormateur) { this.idFormateur = idFormateur;
	 * }
	 * 
	 * public int getDuree() { return duree; }
	 * 
	 * public void setDuree(int duree) { this.duree = duree; }
	 * 
	 * public Date getDateDebut() { return dateDebut; }
	 * 
	 * public void setDateDebut(Date dateDebut) { this.dateDebut = dateDebut; }
	 * 
	 * public double getPrix() { return prix; }
	 * 
	 * public void setPrix(double prix) { this.prix = prix; }
	 * 
	 * public String getLieux() { return lieux; }
	 * 
	 * public void setLieux(String lieux) { this.lieux = lieux; }
	 * 
	 * public String getDescriptif() { return descriptif; }
	 * 
	 * public void setDescriptif(String descriptif) { this.descriptif = descriptif;
	 * }
	 * 
	 * public String getLienTest() { return lienTest; }
	 * 
	 * public void setLienTest(String lienTest) { this.lienTest = lienTest; }
	 * 
	 * public int getIdNiveau() { return idNiveau; }
	 * 
	 * public void setIdNiveau(int idNiveau) { this.idNiveau = idNiveau; }
	 */

	@Override
	public String toString() {
		return "Formation [id=" + id + ", nom=" + nom + "]";
	}

	/*
	 * public Formation(int id, int idCategorie, int idFormateur, int duree, Date
	 * dateDebut, double prix, String lieux, String descriptif, String lienTest, int
	 * idNiveau, String nom) { super(); this.id = id; this.idCategorie =
	 * idCategorie; this.idFormateur = idFormateur; this.duree = duree;
	 * this.dateDebut = dateDebut; this.prix = prix; this.lieux = lieux;
	 * this.descriptif = descriptif; this.lienTest = lienTest; this.idNiveau =
	 * idNiveau; this.nom = nom; }
	 */
	
}
