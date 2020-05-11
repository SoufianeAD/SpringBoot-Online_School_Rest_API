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

import com.esisa.back.office.entities.ClassRoom;
import com.esisa.back.office.repositories.ClassRoomRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/classRoom")
public class ClassRoomController {
	
	@Autowired
	private ClassRoomRepository classRoomRepository;
	
	@PostMapping("/add")
	public ClassRoom add(@RequestBody ClassRoom classRoom) {
		return classRoomRepository.save(classRoom);
	}
	
	@PutMapping("/update")
	public ClassRoom update(@RequestBody ClassRoom classRoom) {
		return classRoomRepository.save(classRoom);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") ObjectId id) {
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
	public Optional<ClassRoom> getByid(@PathVariable("id") ObjectId id) {
		return classRoomRepository.findById(id);
	}
	
	@GetMapping("/getClassRoomsBySchoolId/{id}")
	public List<ClassRoom> getClassRoomsBySchoolId(@PathVariable("id") ObjectId id) {
		return classRoomRepository.findBySchoolId(id);
	}
}
