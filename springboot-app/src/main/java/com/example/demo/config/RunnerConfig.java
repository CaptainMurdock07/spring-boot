package com.example.demo.config;

import com.example.demo.dao.PersonneRepository;
import com.example.demo.models.Personne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// TODO: Auto-generated Javadoc
/**
 * The Class RunnerConfig.
 */
@Component
public class RunnerConfig implements CommandLineRunner {

	/** The personne repository. */
	@Autowired
	private PersonneRepository personneRepository;
	
	/* (non-Javadoc)
	 * @see org.springframework.boot.CommandLineRunner#run(java.lang.String[])
	 */
	
	@Override
	public void run(String... args) throws Exception {
		personneRepository.save(new Personne("NOM1", "PRENOM1", 40));
		personneRepository.save(new Personne("NOM2", "PRENOM2", 30));
		personneRepository.save(new Personne("NOM3", "PRENOM3", 20));
	}
}
