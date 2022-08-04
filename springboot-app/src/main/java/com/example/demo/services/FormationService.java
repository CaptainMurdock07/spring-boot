package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.dao.FormationRepository;
import com.example.demo.models.Formation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "formationService")
public class FormationService implements IService<Formation> {

	@Autowired
	private FormationRepository formationRepository;

	@Override
	public List<Formation> findAll() {
		return formationRepository.findAll();
	}

	@Override
	public Formation saveOrUpdate(Formation o) {
		return formationRepository.save(o);
	}

	@Override
	public Optional<Formation> findById(int id) {
		return formationRepository.findById(id);
	}

	@Override
	public void deleteById(int id) {
		formationRepository.deleteById(id);
	}

	@Override
	public Optional<Formation> getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
