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

import com.esisa.back.office.entities.Level;
import com.esisa.back.office.repositories.LevelRepository;
import com.esisa.back.office.services.SequenceGeneratorService;

@RestController
@CrossOrigin("*")
@RequestMapping("/level")
public class LevelController {
	
	@Autowired
	private LevelRepository levelRepository;
	
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;
	
	@PostMapping("/add")
	public Level add(@RequestBody Level level) {
		level.setId(sequenceGeneratorService.generateSequence(Level.SEQUENCE_NAME));
		return levelRepository.save(level);
	}
	
	@PutMapping("/update")
	public Level update(@RequestBody Level level) {
		return levelRepository.save(level);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") long id) {
		levelRepository.deleteById(id);
	}
	
	@DeleteMapping("/deleteAll")
	public void deleteAll() {
		levelRepository.deleteAll();
	}
	
	@GetMapping("/getAll")
	public List<Level> getAll() {
		return levelRepository.findAll();
	}
	
	@GetMapping("/getById/{id}")
	public Optional<Level> getById(@PathVariable("id") long id) {
		return levelRepository.findById(id);
	}
	
	@GetMapping("/getBySchoolId/{id}")
	public List<Level> getBySchoolId(@PathVariable("id") long id) {
		return levelRepository.findBySchoolId(id);
	}
}
