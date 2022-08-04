package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.dao.PersonneRepository;
import com.example.demo.dao.ProjetRepository;
import com.example.demo.models.Projet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "projetService")
public class ProjetService implements IProjetService, IService<Projet> {

	@Autowired
	private ProjetRepository projetRepository;
	
	@Autowired
	private PersonneRepository personneRepository;
	
	@Override
	public List<Projet> findAll() {
		return projetRepository.findAll();
	}

	@Override
	public Projet saveOrUpdate(Projet o) {
		return projetRepository.save(o);
	}

	@Override
	public Optional<Projet> findById(int id) {
		return projetRepository.findById(id);
	}

	@Override
	public void deleteById(int id) {
		projetRepository.deleteById(id);
	}

	@Override
	public Optional<Projet> getById(int id) {
		return projetRepository.findById(id);
	}
	
	@Override
	public Optional<Projet> getById(Integer id) {
		return projetRepository.findById(id);
	}

	@Override
	public List<Projet> getProjetsByPersonnesId(Integer id) {
		return projetRepository.findByPersonneId(id);
	}

	@Override
	public Optional<Projet> saveOneProjetByPerson(Integer id, Projet projetRequest) {
		Optional<Projet> projet = personneRepository.findById(id).map(personne -> {
			int projetId = projetRequest.getId();
			if (projetId != 0) {
				Projet _projet = projetRepository.findById(projetId).get();
				personne.getProjets().add(_projet);
				personneRepository.save(personne);
				return _projet;
			} else {
				Projet p = new Projet();
				p.setTitre(projetRequest.getTitre());
				personne.getProjets().add(p);
				projetRepository.save(p);
				return p;
			}
		});
		return projet;
	}

	@Override
	public Optional<Projet> editOneProjetByPerson(Integer personneId, Integer projetId, Projet projetRequest) {
		Optional<Projet> projet = personneRepository.findById(personneId).map(personne -> {
            Projet _projet = projetRepository.findById(projetId).get();
            _projet.setTitre(projetRequest.getTitre());
            personne.getProjets().add(_projet);
            personneRepository.save(personne);
            return _projet;
        });
        return projet;
	}

	@Override
	public Optional<Projet> deleteOneProjetByPerson(Integer personneId, Integer projetId) {
		Optional<Projet> projet = personneRepository.findById(personneId).map(personne -> {
            Projet _projet = projetRepository.findById(projetId).get();
            personne.getProjets().remove(_projet);
            personneRepository.save(personne);
            return _projet;
        });
        return projet;
	}

}
