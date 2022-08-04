package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.Personne;
import com.example.demo.models.Projet;
import com.example.demo.services.IProjetService;
import com.example.demo.services.IService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@CrossOrigin(origins = "*")
public class ProjetRestController {
	
	@Autowired
	private IService<Personne> personneService;
	
	@Autowired
	private IProjetService projetService;

	@GetMapping("/projets")
	public ResponseEntity<List<Projet>> getAllProjets() {		
		List<Projet> projets = projetService.findAll();		
		return new ResponseEntity<>(projets, HttpStatus.OK);
	}
	
	@PostMapping(value = "/projets")
	public ResponseEntity<Projet> save(@RequestBody Projet p) {
		return new ResponseEntity<>(projetService.saveOrUpdate(p), HttpStatus.CREATED);
	}
	
	@GetMapping("/personnes/{personneId}/projets")
	public ResponseEntity<List<Projet>> getAllProjetsByPersonneId(@PathVariable(value = "personneId") Integer personneId) {
		personneService.getById(personneId).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Person not found with id : " + personneId));
		List<Projet> projets = projetService.getProjetsByPersonnesId(personneId);
		return new ResponseEntity<>(projets, HttpStatus.OK);
	}
	

    @PostMapping("/personnes/{personneId}/projets")
    public ResponseEntity<Projet> addProjectByPersonneNum(@PathVariable(value = "personneId") Integer personneId, @RequestBody Projet projet){
       Projet projetToSave = projetService.saveOneProjetByPerson(personneId, projet).orElseThrow(
               () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Person not found with id : " + personneId));
       return new ResponseEntity<>(projetToSave, HttpStatus.CREATED);
    }

	
//	  @GetMapping("/personnes/{personneId}/projets/{projetId}")
//	  public ResponseEntity<Projet> getProjetByPersonneNum(@PathVariable(value =
//	  "personneId") Integer personneId, @PathVariable(value = "projetId") Integer projetId) {
//		  Projet projetById = projetService.getById(projetId).orElseThrow(
//				  () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
//		  
//	  }
//	 
//
//	@PutMapping("/personnes/{personneId}/projets/{projetId}")
//	public ResponseEntity<Projet> editOneProjetByPerson(@PathVariable(value = "personneId") Integer personneId, @PathVariable(value = "projetId") Integer projetId, @RequestBody Projet projet) {
//		Projet projetToEdit = projetService.editOneProjetByPerson(personneId, projetId, projet).orElseThrow(
//				() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
//		return new ResponseEntity<Projet>(projetToEdit, HttpStatus.)
//	}
//
//	@DeleteMapping("/personnes/{personneId}/projets/{projetId}")
//	public Optional<Projet> deleteOneProjetByPerson(Integer personneId, Integer projetId) {
//		return null;
//	}

}
