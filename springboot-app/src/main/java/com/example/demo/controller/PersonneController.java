package com.example.demo.controller;

import java.util.List;

import com.example.demo.dao.PersonneRepository;
import com.example.demo.models.Personne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

// TODO: Auto-generated Javadoc
/**
 * The Class PersonneController.
 */
@Controller
public class PersonneController {

	/** The personne repository. */
	// Injection de la dependance du DAO (Data Access Object) sur l'entite Personne
	@Autowired
	private PersonneRepository personneRepository;
	
	/**
	 * Show all.
	 *
	 * @param model the model
	 * @return the string
	 */
	/*
	 * public PersonneController(PersonneRepository personneRepository) {
	 * this.personneRepository = personneRepository; }
	 */
	@GetMapping(value = "/showAll")
	public String showAll(ModelMap model) {
		List<Personne> personnes = personneRepository.findAll();
		model.addAttribute("personnes", personnes);
		return "jsp/home";
	}
	
	/**
	 * Show some.
	 *
	 * @param nom the nom
	 * @param prenom the prenom
	 * @param model the model
	 * @return the string
	 */
	// http://localhost:8080/showSome?nom=NOM1&prenom=PRENOM1
		@GetMapping(value = "/showSome")
		public String showSome(@RequestParam(value = "nom", required = false, defaultValue = "") String nom, @RequestParam(value = "prenom", required = false, defaultValue= "") String prenom, ModelMap model) {
			List<Personne> personnes = personneRepository.findByNomAndPrenom(nom, prenom);
			model.addAttribute("personnes", personnes);
			return "jsp/home";
		}
		
		// Affiche une liste triee selon le nom decroissant
		/**
		 * Show sort.
		 *
		 * @param model the model
		 * @return the string
		 */
		// http://localhost:8080/showSort
		@GetMapping(value = "/showSort")
		public String showSort(ModelMap model) {
			List<Personne> personnes = personneRepository.findAll(Sort.by("nom").descending());
			model.addAttribute("personnes", personnes);
			return "jsp/home";
		}
}
