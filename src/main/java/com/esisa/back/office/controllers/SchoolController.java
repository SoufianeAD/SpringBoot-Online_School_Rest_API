package com.esisa.back.office.controllers;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping("/school")
public class SchoolController {

	@Autowired
	private SchoolRepository schoolRepository;
	
	@PostMapping("/add")
	public School add(@RequestBody School school) {
		return schoolRepository.save(school);
	}
	
	@PutMapping("/update")
	public School update(@RequestBody School school) {
		return schoolRepository.save(school);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") ObjectId id) {
		schoolRepository.deleteById(id);
	}
	
	@GetMapping("/getAll")
	public List<School> getAll() {
		schoolRepository.save(new School("ESISA", "Ibn Khatib, Fes", "053698741", "www.esisa.ma"));
		schoolRepository.save(new School("ENCG", "Ibn Khatib, Fes", "053698741", "www.esisa.ma"));
		return schoolRepository.findAll();
	}
	
	@GetMapping("/getByid/{id}")
	public School getByid(@PathVariable("id") ObjectId id) {
		return schoolRepository.findByid(id);
	}
	
}
