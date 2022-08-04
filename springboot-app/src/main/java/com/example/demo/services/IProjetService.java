package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.Projet;

public interface IProjetService {
	
	List<Projet> findAll();
	
	Projet saveOrUpdate(Projet p);

	Optional<Projet> getById(Integer id);

	List<Projet> getProjetsByPersonnesId(Integer id);

	Optional<Projet> saveOneProjetByPerson(Integer id, Projet projetRequest);

	Optional<Projet> editOneProjetByPerson(Integer personneId, Integer projetId, Projet projetRequest);

	Optional<Projet> deleteOneProjetByPerson(Integer personneId, Integer projetId);

}
