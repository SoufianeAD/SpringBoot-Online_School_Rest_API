package com.esisa.back.office.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esisa.back.office.entities.Absence;
import com.esisa.back.office.repositories.AbsenceRepository;
import com.esisa.back.office.services.SequenceGeneratorService;

@RestController
@CrossOrigin("*")
@RequestMapping("/absence")
public class AbsenceController {
	
	@Autowired
	private AbsenceRepository absenceRepository;
	
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;
	
	@PostMapping("/add")
	public Absence add(@RequestBody Absence absence) {
		absence.setId(sequenceGeneratorService.generateSequence(Absence.SEQUENCE_NAME));
		return absenceRepository.save(absence);
	}
	
	@PutMapping("/update")
	public Absence update(@RequestBody Absence absence) {
		return absenceRepository.save(absence);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") long id) {
		absenceRepository.deleteById(id);
	}
	
	@DeleteMapping("/deleteAll")
	public void deleteAll() {
		absenceRepository.deleteAll();
	}
	
	@GetMapping("/getAll")
	public List<Absence> getAll() {
		return absenceRepository.findAll();
	}
	
	@GetMapping("/getById/{id}")
	public Optional<Absence> getById(@PathVariable("id") long id) {
		return absenceRepository.findById(id);
	}
	
	@GetMapping("/getByStudentId/{id}")
	public List<Absence> getByStudentId(@PathVariable("id") long id) {
		return absenceRepository.findByStudentId(id);
	}

}
