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

import com.esisa.back.office.entities.ClassRoom;
import com.esisa.back.office.repositories.ClassRoomRepository;
import com.esisa.back.office.services.SequenceGeneratorService;

@RestController
@CrossOrigin("*")
@RequestMapping("/classRoom")
public class ClassRoomController {
	
	@Autowired
	private ClassRoomRepository classRoomRepository;
	
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;
	
	@PostMapping("/add")
	public ClassRoom add(@RequestBody ClassRoom classRoom) {
		classRoom.setId(sequenceGeneratorService.generateSequence(ClassRoom.SEQUENCE_NAME));
		return classRoomRepository.save(classRoom);
	}
	
	@PutMapping("/update")
	public ClassRoom update(@RequestBody ClassRoom classRoom) {
		return classRoomRepository.save(classRoom);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") long id) {
		classRoomRepository.deleteById(id);
	}
	
	@DeleteMapping("/deleteAll")
	public void deleteAll() {
		classRoomRepository.deleteAll();
	}
	
	@GetMapping("/getAll")
	public List<ClassRoom> getAll() {
		return classRoomRepository.findAll();
	}
	
	@GetMapping("/getByid/{id}")
	public Optional<ClassRoom> getByid(@PathVariable("id") long id) {
		return classRoomRepository.findById(id);
	}
	
	@GetMapping("/getByLevelId/{id}")
	public List<ClassRoom> getByLevelId(@PathVariable("id") long id) {
		return classRoomRepository.findByLevelId(id);
	}
}
