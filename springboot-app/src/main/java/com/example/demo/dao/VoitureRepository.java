package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.Voiture;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoitureRepository extends JpaRepository<Voiture, Integer> {

	List<Voiture> findByPersonneId(Integer personneId);
	
	Optional<Voiture> findByIdAndPersonneId(Integer id, Integer PersonneId);
}
