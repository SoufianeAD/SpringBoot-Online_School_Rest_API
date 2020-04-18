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

import com.esisa.back.office.entities.Administrator;
import com.esisa.back.office.entities.Professor;
import com.esisa.back.office.repositories.AdministratorRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/administrator")
public class AdministratorController {

	@Autowired
	private AdministratorRepository administratorRepository;
	
	@PostMapping("/add")
	public Administrator add(@RequestBody Administrator administrator) {
		return administratorRepository.save(administrator);
	}
	
	@PutMapping("/update")
	public Administrator update(@RequestBody Administrator administrator) {
		return administratorRepository.save(administrator);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") ObjectId id) {
		administratorRepository.deleteById(id);
	}
	
	@DeleteMapping("/deleteAll")
	public void deleteAll() {
		administratorRepository.deleteAll();
	}
	
	@GetMapping("/getAll")
	public List<Administrator> getAll() {
		return administratorRepository.findAll();
	}
	
	@GetMapping("/getById/{id}")
	public Optional<Administrator> getById(@PathVariable("id") ObjectId id) {
		return administratorRepository.findById(id);
	}
	
	/* Oussama Controller */

	@GetMapping("/getAllBySchoolId/{id}")
	public List<Administrator> getAllBySchoolId(@PathVariable("id") ObjectId id) {
		return administratorRepository.findByAccountSchoolId(id);
	}
	@GetMapping(path="/geByUsernameAndPassword/{username}/{password}")
	public Administrator geByUsernameAndPassword(@PathVariable("username") String username , @PathVariable("password") String password) {
		return administratorRepository.findByAccountUserNameAndAccountPassword(username, password);
	}
	
}
