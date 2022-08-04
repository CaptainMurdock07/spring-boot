package com.example.demo.dao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.models.Personne;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PersonneRepositoryTest {

	@Autowired
	private PersonneRepository personneRepository;

	/** The entity manager. */
	@Autowired
	private TestEntityManager entityManager;

	/**
	 * Test get personnes.
	 */
	@Test
	void testGetPersonnes() {

		Personne personne1 = new Personne("admin", "admin", 10);
		Personne personne2 = new Personne("admin2", "admin2", 20);
		List<Personne> personneList = new ArrayList<>();

		personneList.add(personne1);
		personneList.add(personne2);

		entityManager.persist(personne1);
		entityManager.persist(personne2);

		List<Personne> personnesFromDb = personneRepository.findAll();

		assertEquals(personneList, personnesFromDb);

		assertThat(personnesFromDb.equals(personneList));
	}

	@Test
	void testGetPersonneById() {
		Personne personne1 = new Personne("admin", "admin", 10);

		Personne personneSavedInDb = entityManager.persist(personne1);
		Personne personneFromDb = personneRepository.findById(personne1.getId()).get();
		assertEquals(personneSavedInDb, personneFromDb);

		assertThat(personneFromDb.equals(personneSavedInDb));
	}

	@Test
	void testSave() {		
		Personne personne1 = new Personne("admin", "admin", 10);
		Personne savedInDb = entityManager.persist(personne1);
		Personne getFromDb = personneRepository.findById(savedInDb.getId()).get();
		assertEquals(savedInDb, getFromDb);
		assertThat(getFromDb).isEqualTo(savedInDb);	
	}
	
	@Test
	void testDeletePersonne() {
		Personne personne1 = new Personne("admin", "admin", 10);
		Personne personne2 = new Personne("admin2", "admin2", 20);
		List<Personne> personneList = new ArrayList<>();
		
		personneList.add(personne1);
		personneList.add(personne2);

		entityManager.persist(personne1);
		entityManager.persist(personne2);
		
		Personne getFromDb = personneRepository.findById(personne2.getId()).get();
		entityManager.remove(getFromDb);
		
		assertThat(!personneList.contains(getFromDb));
	}
	
	@Test
	void testUpdate() {
		Personne personne1 = new Personne("admin", "admin", 10);
		Personne savedInDb = entityManager.persist(personne1);
		Personne getFromDb = personneRepository.findById(personne1.getId()).get();
		getFromDb.setNom("admino");
		entityManager.persist(getFromDb);
		assertThat(getFromDb.getNom()).isEqualTo("admino");
	}

}