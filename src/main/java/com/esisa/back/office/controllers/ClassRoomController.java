package com.esisa.back.office.controllers;

import java.util.List;
import java.util.Optional;

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

import com.esisa.back.office.entities.ClassRoom;
import com.esisa.back.office.entities.School;
import com.esisa.back.office.repositories.ClassRoomRepository;
import com.esisa.back.office.repositories.SchoolRepository;

@RestController
@RequestMapping("/classRoom")
public class ClassRoomController {
	
	@Autowired
	private ClassRoomRepository classRoomRepository;
	
	@Autowired
	private SchoolRepository schoolRepository;
	
	@PostMapping("/add")
	public ClassRoom add(@RequestBody ClassRoom classRoom) {
		return classRoomRepository.save(classRoom);
	}
	
	@PutMapping("/update")
	public ClassRoom update(@RequestBody ClassRoom classRoom) {
		return classRoomRepository.save(classRoom);
	}
	
	@DeleteMapping("/delete/{_id}")
	public void delete(@PathVariable("_id") ObjectId _id) {
		classRoomRepository.deleteById(_id);
	}
	
	@GetMapping("/getAll")
	public List<ClassRoom> getAll() {
		return classRoomRepository.findAll();
	}
	
	@GetMapping("/getBy_id/{_id}")
	public Optional<ClassRoom> getBy_id(@PathVariable("_id") ObjectId _id) {
		return classRoomRepository.findById(_id);
	}
}
