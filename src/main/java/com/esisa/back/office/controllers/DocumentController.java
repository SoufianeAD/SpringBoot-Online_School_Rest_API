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

import com.esisa.back.office.entities.Document;
import com.esisa.back.office.repositories.DocumentRepository;

@RestController
@RequestMapping("/document")
public class DocumentController {

	@Autowired
	private DocumentRepository documentRepository;
	
	@PostMapping("/add")
	public Document add(@RequestBody Document document) {
		return documentRepository.save(document);
	}
	
	@PutMapping("/update")
	public Document update(@RequestBody Document document) {
		return documentRepository.save(document);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") ObjectId id) {
		documentRepository.deleteById(id);
	}
	
	@DeleteMapping("/deleteAll")
	public void deleteAll() {
		documentRepository.deleteAll();
	}
	
	@GetMapping("/getAll")
	public List<Document> getAll() {
		return documentRepository.findAll();
	}
	
	@GetMapping("/getById/{id}")
	public Optional<Document> getById(@PathVariable("id") ObjectId id) {
		return documentRepository.findById(id);
	}
}
