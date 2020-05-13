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

import com.esisa.back.office.entities.File;
import com.esisa.back.office.repositories.FileRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/file")
public class FileController {
	
	@Autowired
	private FileRepository fileRepository;
	
	@PostMapping("/add")
	public File add(@RequestBody File file) {
		return fileRepository.save(file);
	}
	
	@PutMapping("/update")
	public File update(@RequestBody File file) {
		return fileRepository.save(file);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") ObjectId id) {
		fileRepository.deleteById(id);
	}
	
	@DeleteMapping("/deleteAll")
	public void deleteAll() {
		fileRepository.deleteAll();
	}
	
	@GetMapping("/getById/{id}")
	public Optional<File> getById(@PathVariable("id") ObjectId id) {
		return fileRepository.findById(id);
	}
	
	@GetMapping("/getByDocumentId/{id}")
	public List<File> getByDocumentId(@PathVariable("id") ObjectId id) {
		return fileRepository.findByDocumentId(id);
	}

}
