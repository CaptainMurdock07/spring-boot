package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.Personne;
import com.example.demo.services.IService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

// TODO: Auto-generated Javadoc
/**
 * The Class PersonneRestController.
 */
@RestController
@CrossOrigin(origins = "*") // Autorise la communication entre application front-end et back-end
public class PersonneRestController {

	/** The personne service. */
	@Autowired
	private IService<Personne> personneService;

	// Retourne une liste de personnes
	/**
	 * Show all.
	 *
	 * @return the list
	 */
	// http://localhost:8080/personnes
	@GetMapping(value = "/personnes")
	public List<Personne> showAll() {
		return personneService.findAll();
	}

	// Enregistre un objet de type personne en db
	// http://localhost:8080/personnes
	/*
	 * @PostMapping(value = "/personnes") public Personne save(@RequestBody Personne
	 * p) { return personneService.save(p); }
	 */

	// Retourne un objet de type Personne selon son identifiant
	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the optional
	 */
	// http://localhost:8080/personnes

	@GetMapping(value = "/personnes/{id}")
	public Optional<Personne> findById(@RequestParam int id) {
		return personneService.findById(id);
	}

	// Met a jour un objet de type Personne selon son identifiant
	/**
	 * Save or update.
	 *
	 * @param personne the personne
	 * @param id       the id
	 */
	// http://localhost:8080/personnes

	/*
	 * @PostMapping(value = "/personnes/{id}") public Personne
	 * saveOrUpdate(@RequestBody Personne personne, @PathVariable("id") Integer id)
	 * { Personne personneToUpdate = personneService.findById(id); if
	 * (personneToUpdate == null) { throw new
	 * ResponseStatusException(HttpStatus.NOT_FOUND); } else {
	 * personneToUpdate.setNom(personne.getNom());
	 * personneToUpdate.setPrenom(personne.getPrenom());
	 * personneToUpdate.setAge(personne.getAge()); } return
	 * personneService.saveOrUpdate(personneToUpdate); }
	 */

	// Supprimer un objet de type Personne selon son identifiant
	// http://localhost:8080/personnes

	@DeleteMapping(value = "/personnes/{id}")
	public void deleteById(int id) {
		personneService.deleteById(id);
	}

}
