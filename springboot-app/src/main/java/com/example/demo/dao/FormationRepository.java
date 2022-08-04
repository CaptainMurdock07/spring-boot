package com.example.demo.dao;

import java.util.List;

import com.example.demo.models.Formation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormationRepository extends JpaRepository<Formation, Integer> {

	List<Formation> findByNom(String nom);
}
