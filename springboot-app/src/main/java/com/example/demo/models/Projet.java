package com.example.demo.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Projet {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
	private Integer id;
	private String titre;
	
	@ManyToMany(mappedBy = "projets")
	private List<Personne> personnes = new ArrayList<Personne>();

	public Projet() {
		super();
	}

	public Projet(Integer id, String titre, List<Personne> personnes) {
		super();
		this.id = id;
		this.titre = titre;
		this.personnes = personnes;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public List<Personne> getPersonnes() {
		return personnes;
	}

	public void setPersonnes(List<Personne> personnes) {
		this.personnes = personnes;
	}

	@Override
	public String toString() {
		return "Projet [id=" + id + ", titre=" + titre + ", personnes=" + personnes + "]";
	}
	
	
}
