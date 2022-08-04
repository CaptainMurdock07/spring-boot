package com.example.demo.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.example.demo.dao.PersonneRepository;
import com.example.demo.models.Personne;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

public class PersonneServiceTest {
	
	@Autowired
	private PersonneRepository personneRepository;
	
	@Autowired
	private PersonneService personneService;

	@Test
	public void testGetPersonnes() throws Exception {
		
		Personne personne = new Personne("admin", "admin", 10);
		
		List<Personne> allPersonnes = Arrays.asList(personne);
		
		Mockito.when(personneRepository.findAll()).thenReturn(allPersonnes);
		
		Collection<Personne> personnes = personneService.findAll();
		assertNotNull(personnes);
		assertEquals(personnes, allPersonnes);
		assertEquals(personnes.size(), allPersonnes.size());
		verify(personneRepository).findAll();
	}
	
	@Test
	public void testSave() throws Exception {
		
		Personne personne = new Personne("admin", "admin", 10);
		
		Mockito.when(personneRepository.save((personne))).thenReturn(personne);
		Personne personneSaved = personneService.saveOrUpdate(personne);
		assertNotNull(personneSaved);
		assertEquals(personne.getId(), personneSaved.getId());
		assertEquals(personne.getNom(), personneSaved.getNom());

		verify(personneRepository).save(personne);

	}
	
	@Test
	public void testDelete() throws Exception {
		Personne personne = new Personne("admin", "admin", 10);
		Personne personneMock = new Personne("admin", "admin", 10);
		Mockito.when(personneRepository.save((personne))).thenReturn(personneMock);
		Personne personneSaved = personneService.saveOrUpdate(personne);
		assertNotNull(personneSaved);
		assertEquals(personneMock.getId(), personneSaved.getId());
		personneService.deleteById(personneSaved.getId());

		verify(personneRepository).deleteById(1);

	}
	
	@Test
	public void testUpdatePersonne() throws Exception {
		Personne personneToUpdate = new Personne("admin", "admin", 10);
		Personne personneUpdated = new Personne("admini", "admin", 10);
		Mockito.when(personneRepository.save((personneToUpdate))).thenReturn(personneUpdated);
		Personne personneFromDB = personneService.saveOrUpdate(personneToUpdate);
		assertNotNull(personneFromDB);
		assertEquals(personneUpdated.getId(), personneFromDB.getId());

	}
}
