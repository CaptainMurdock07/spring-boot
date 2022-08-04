package com.exemple.models;

public class Personne {

	private Integer id;
	private String nom;
	
	public Personne() {
		super();
	}

	public Personne(Integer id, String nom) {
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

	@Override
	public String toString() {
		return "Personne [id=" + id + ", nom=" + nom + "]";
	}
	
}
