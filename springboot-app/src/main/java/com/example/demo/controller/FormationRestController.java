package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.Formation;
import com.example.demo.services.IService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*") // Autorise la communication entre application front-end et back-end
public class FormationRestController {

	@Autowired
	private IService<Formation> formationService;

	// http://localhost:8080/formations
	@GetMapping(value = "/formations")
	public List<Formation> showAll() {
		return formationService.findAll();
	}

	// http://localhost:8080/formations
	@PostMapping(value = "/formations")
	public Formation save(@RequestBody Formation p) {
		return formationService.saveOrUpdate(p);
	}

	// http://localhost:8080/formations
	@GetMapping(value = "/formations/{id}")
	public Optional<Formation> findById(@RequestParam int id) {
		return formationService.findById(id);
	}

}
