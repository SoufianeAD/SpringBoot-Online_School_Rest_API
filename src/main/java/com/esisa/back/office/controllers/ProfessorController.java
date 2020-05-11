package com.esisa.back.office.controllers;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
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

@RestController
@CrossOrigin("*")
@RequestMapping("/professor")
public class ProfessorController {

	@Autowired
	private ProfessorRepository professorRepository;
	
	@PostMapping("/add")
	public Professor add(@RequestBody Professor professor) {
		return professorRepository.save(professor);
	}
	
	@PutMapping("/update")
	public Professor update(@RequestBody Professor professor) {
		return professorRepository.save(professor);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") ObjectId id) {
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
	public Optional<Professor> getById(@PathVariable("id") ObjectId id) {
		return professorRepository.findById(id);
	}
	
	/* Oussama Controller */

	@GetMapping("/getAllBySchoolId/{id}")
	public List<Professor> getAllBySchoolId(@PathVariable("id") ObjectId id) {
		return professorRepository.findByAccountSchoolId(id);
	}
}
