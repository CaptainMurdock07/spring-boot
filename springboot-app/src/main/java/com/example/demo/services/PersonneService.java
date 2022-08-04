package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.dao.PersonneRepository;
import com.example.demo.models.Formation;
import com.example.demo.models.Personne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// TODO: Auto-generated Javadoc
/**
 * The Class PersonneService.
 */
@Service(value = "personneService")
public class PersonneService implements IService<Personne> {

	/** The personne repository. */
	@Autowired
	private PersonneRepository personneRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.example.demo.services.IService#findAll()
	 */

	@Override
	public List<Personne> findAll() {
		return personneRepository.findAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.example.demo.services.IService#saveOrUpdate(java.lang.Object)
	 */

	@Override
	public Personne saveOrUpdate(Personne o) {
		return personneRepository.save(o);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.example.demo.services.IService#findById(int)
	 */
	@Override
	public Optional<Personne> findById(int id) {
		return personneRepository.findById(id);
	}
	
	
	  @Override public Optional<Personne> getById(int id) {
		  return personneRepository.findById(id); }
	 

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.example.demo.services.IService#deleteById(int)
	 */

	@Override
	public void deleteById(int id) {
		personneRepository.deleteById(id);
	}
	
}
