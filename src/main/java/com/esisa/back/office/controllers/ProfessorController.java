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

import com.esisa.back.office.entities.Professor;
import com.esisa.back.office.repositories.ProfessorRepository;
import com.esisa.back.office.services.SequenceGeneratorService;

@RestController
@CrossOrigin("*")
@RequestMapping("/professor")
public class ProfessorController {

	@Autowired
	private ProfessorRepository professorRepository;
	
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;
	
	@PostMapping("/add")
	public Professor add(@RequestBody Professor professor) {
		professor.setId(sequenceGeneratorService.generateSequence(Professor.SEQUENCE_NAME));
		return professorRepository.save(professor);
	}
	
	@PutMapping("/update")
	public Professor update(@RequestBody Professor professor) {
		return professorRepository.save(professor);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") long id) {
		professorRepository.deleteById(id);
	}
	
	@DeleteMapping("/deleteAll")
	public void deleteAll() {
		professorRepository.deleteAll();
	}
	
	@GetMapping("/getAll")
	public List<Professor> getAll() {
		return professorRepository.findAll();
	}
	
	@GetMapping("/getById/{id}")
	public Optional<Professor> getById(@PathVariable("id") long id) {
		return professorRepository.findById(id);
	}
	
	@GetMapping("/getBySchoolId/{id}")
	public List<Professor> getBySchoolId(@PathVariable("id") long id) {
		return professorRepository.findByAccountSchoolId(id);
	}
	
	@GetMapping("/getByUsernameAndPassword/{username}/{password}")
	public Professor getByUsernameAndPassword(@PathVariable("username") String username , @PathVariable("password") String password) {
		return professorRepository.findByAccountUserNameAndAccountPassword(username, password);
	}
}
