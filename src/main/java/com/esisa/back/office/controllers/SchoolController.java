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

import com.esisa.back.office.entities.School;
import com.esisa.back.office.repositories.SchoolRepository;
import com.esisa.back.office.services.SequenceGeneratorService;

@RestController
@CrossOrigin("*")
@RequestMapping("/school")
public class SchoolController {

	@Autowired
	private SchoolRepository schoolRepository;
	
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;
	
	@PostMapping("/add")
	public School add(@RequestBody School school) {
		school.setId(sequenceGeneratorService.generateSequence(School.SEQUENCE_NAME));
		return schoolRepository.save(school);
	}
	
	@PutMapping("/update")
	public School update(@RequestBody School school) {
		return schoolRepository.save(school);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") long id) {
		schoolRepository.deleteById(id);
	}
	
	@DeleteMapping("/deleteAll")
	public void deleteAll() {
		schoolRepository.deleteAll();
	}
	
	@GetMapping("/getAll")
	public List<School> getAll() {
		return schoolRepository.findAll();
	}
	
	@GetMapping("/getByid/{id}")
	public Optional<School> getByid(@PathVariable("id") long id) {
		return schoolRepository.findById(id);
	}
	
}
