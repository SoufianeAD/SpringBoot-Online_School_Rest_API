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

import com.esisa.back.office.entities.School;
import com.esisa.back.office.entities.Student;
import com.esisa.back.office.repositories.StudentRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;
	
	@PostMapping("/add")
	public Student add(@RequestBody Student student) {
		return studentRepository.save(student);
	}
	
	@PutMapping("/update")
	public Student update(@RequestBody Student student) {
		return studentRepository.save(student);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") ObjectId id) {
		studentRepository.deleteById(id);
	}
	
	@DeleteMapping("/deleteAll")
	public void deleteAll() {
		studentRepository.deleteAll();
	}
	
	@GetMapping("/getAll")
	public List<Student> getAll() {
		return studentRepository.findAll();
	}
	
	@GetMapping("/getById/{id}")
	public Optional<Student> getById(@PathVariable("id") ObjectId id) {
		return studentRepository.findById(id);
	}
	
	/* Oussama Controller */
	
	@GetMapping("/getAllBySchoolId/{id}")
	public List<Student> getAllBySchoolId(@PathVariable("id") ObjectId id) {
		return studentRepository.findByAccountSchoolId(id);
	}
}
