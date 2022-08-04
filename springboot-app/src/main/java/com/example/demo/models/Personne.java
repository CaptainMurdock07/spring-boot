package com.example.demo.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

// TODO: Auto-generated Javadoc
/**
 * The Class Personne.
 */
@Entity
//Declare l'heritage et le mapping des classes filles 
//ds une seule table (a la difference TABLE_PER_CLASS)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_PERSONNE")
@DiscriminatorValue(value = "PERS")
//Definit des contraintes d'unicites sur nom et prenom
@Table(name = "personne", uniqueConstraints = {
		@UniqueConstraint(name = "nom_prenom", columnNames = { "nom", "prenom" }) })
public class Personne {

	/** The id. */
	@Id // Declare ce champ comme PK
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
	private Integer id;

	/** The nom. */
	private String nom;
	
	/** The prenom. */
	private String prenom;
	
	/** The age. */
	private int age;
	//private static Long count;
	
	@OneToMany(cascade = {CascadeType.ALL})
	private List<Voiture> voitures = new ArrayList<>();
	
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name = "personnes_projets", joinColumns = { @JoinColumn(name = "id_personne") }, inverseJoinColumns = {
			@JoinColumn(name = "id_projet") })	
	private List<Projet> projets = new ArrayList<>();
	
	public List<Voiture> getVoitures() {
		return voitures;
	}

	public void setVoitures(List<Voiture> voitures) {
		this.voitures = voitures;
	}

	/**
	 * Instantiates a new personne.
	 */
	public Personne() {
		super();
	}

	/**
	 * Instantiates a new personne.
	 *
	 * @param nom the nom
	 * @param prenom the prenom
	 * @param age the age
	 */
	public Personne(String nom, String prenom, int age) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
	}
	
	public Personne(Integer id, List<Voiture> voitures, List<Projet> sports, String nom, String prenom, int age) {
		super();
		this.id = id;
		this.voitures = voitures;
		this.projets = projets;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Gets the nom.
	 *
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Sets the nom.
	 *
	 * @param nom the new nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Gets the prenom.
	 *
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * Sets the prenom.
	 *
	 * @param prenom the new prenom
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * Gets the age.
	 *
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Sets the age.
	 *
	 * @param age the new age
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	
	public List<Projet> getProjets() {
		return projets;
	}

	public void setSports(List<Projet> projets) {
		this.projets = projets;
	}

	@Override
	public String toString() {
		return "Personne [id=" + id + ", voitures=" + voitures + ", projets=" + projets + ", nom=" + nom + ", prenom="
				+ prenom + ", age=" + age + "]";
	}

}