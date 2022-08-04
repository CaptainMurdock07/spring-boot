package com.exemple.config;

import com.exemple.models.Personne;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// Configuration permet de declarer pour Spring un composant qui ne sert qu'a configurer le contexte de l'application
@Configuration
// Permet d'indiquer l'emplacement de beans
@ComponentScan("com.exemple.nation")
public class AppConfig {

	// Un bean est un objet qui est instancié, assemblé et géré par Spring Core et sa factory
	@Bean(name = "personne")
	public Personne personne() {
		return new Personne(1, "John");
	}
}
