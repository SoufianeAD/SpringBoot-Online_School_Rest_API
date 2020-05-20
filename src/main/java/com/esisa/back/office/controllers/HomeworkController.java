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

import com.esisa.back.office.entities.Homework;
import com.esisa.back.office.repositories.HomeworkRepository;
import com.esisa.back.office.services.SequenceGeneratorService;

@RestController
@CrossOrigin("*")
@RequestMapping("/homework")
public class HomeworkController {

	@Autowired
	private HomeworkRepository homeworkRepository;
	
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;
	
	@PostMapping("/add")
	public Homework add(@RequestBody Homework homework) {
		homework.setId(sequenceGeneratorService.generateSequence(Homework.SEQUENCE_NAME));
		return homeworkRepository.save(homework);
	}
	
	@PutMapping("/update")
	public Homework update(@RequestBody Homework homework) {
		return homeworkRepository.save(homework);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") long id) {
		homeworkRepository.deleteById(id);
	}
	
	@DeleteMapping("/deleteAll")
	public void deleteAll() {
		homeworkRepository.deleteAll();
	}
	
	@GetMapping("/getAll")
	public List<Homework> getAll() {
		return homeworkRepository.findAll();
	}
	
	@GetMapping("/getById/{id}")
	public Optional<Homework> getById(@PathVariable("id") long id) {
		return homeworkRepository.findById(id);
	}
	
	@GetMapping("/getByClassRoomId/{id}")
	public List<Homework> getByClassRoomId(@PathVariable("id") long id) {
		return homeworkRepository.findByClassRoomId(id);
	}
	
}
