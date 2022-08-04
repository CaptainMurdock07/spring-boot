package com.example.demo.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//CascadeType.PERSIST : lors de la persistance d'une personne, conserve également voitures.
// CascadeType.REMOVE : lors de la suppression d'une personne, il supprime également les entités voitures.
// CascadeType.REFRESH : lors de l'actualisation d'une personne, actualise également les entités contenues dans voitures.
// CascadeType.MERGE : lors de la fusion de l'état de l'entité personne, fusionne également les entités contenues dans voitures.
// @JsonIgnore : marque une propriété ou une liste de propriétés à ignorer
@Entity
@Table(name = "voiture")
public class Voiture {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
	private Integer id;
	private String couleur;
	private String marque;
	private String modele;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	private Personne personne;
	
	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	public Voiture() {
		super();
	}

	public Voiture(String couleur, String marque, String modele) {
		super();
		this.couleur = couleur;
		this.marque = marque;
		this.modele = modele;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	@Override
	public String toString() {
		return "Voiture [id=" + id + ", couleur=" + couleur + ", marque=" + marque + ", modele=" + modele + "]";
	}
	
	
}
