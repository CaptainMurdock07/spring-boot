package com.example.demo.dao;

import java.util.List;

import com.example.demo.models.Projet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetRepository extends JpaRepository<Projet, Integer> {

	List<Projet> findByPersonneId(Integer personneId);
}
