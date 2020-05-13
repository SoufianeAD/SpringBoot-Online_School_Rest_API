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

import com.esisa.back.office.entities.Session;
import com.esisa.back.office.repositories.SessionRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/session")
public class SessionController {
	
	@Autowired
	private SessionRepository sessionRepository;
	
	@PostMapping("/add")
	public Session add(@RequestBody Session session) {
		return sessionRepository.save(session);
	}
	
	@PutMapping("/update")
	public Session update(@RequestBody Session session) {
		return sessionRepository.save(session);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") ObjectId id) {
		sessionRepository.deleteById(id);
	}
	
	@DeleteMapping("/deleteAll")
	public void deleteAll() {
		sessionRepository.deleteAll();
	}
	
	@GetMapping("/getAll")
	public List<Session> getAll() {
		return sessionRepository.findAll();
	}
	
	@GetMapping("/getById/{id}")
	public Optional<Session> getById(@PathVariable("id") ObjectId id) {
		return sessionRepository.findById(id);
	}
	
	@GetMapping("/getByClassRoomId/{id}")
	public List<Session> getByClassRoomId(@PathVariable("id") ObjectId id) {
		return sessionRepository.findByClassRoomId(id);
	}
}
