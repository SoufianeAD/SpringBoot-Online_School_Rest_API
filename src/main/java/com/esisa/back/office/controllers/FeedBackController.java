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

import com.esisa.back.office.entities.FeedBack;
import com.esisa.back.office.repositories.FeedBackRepository;
import com.esisa.back.office.services.SequenceGeneratorService;

@RestController
@CrossOrigin("*")
@RequestMapping("/feedBack")
public class FeedBackController {
	
	@Autowired
	private FeedBackRepository feedBackRepository;
	
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;
	
	@PostMapping("/add")
	public FeedBack add(@RequestBody FeedBack feedBack) {
		feedBack.setId(sequenceGeneratorService.generateSequence(FeedBack.SEQUENCE_NAME));
		return feedBackRepository.save(feedBack);
	}
	
	@PutMapping("/update")
	public FeedBack update(@RequestBody FeedBack feedBack) {
		return feedBackRepository.save(feedBack);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") long id) {
		feedBackRepository.deleteById(id);
	}
	
	@DeleteMapping("/deleteAll")
	public void deleteAll() {
		feedBackRepository.deleteAll();
	}
	
	@GetMapping("/getAll")
	public List<FeedBack> getAll() {
		return feedBackRepository.findAll();
	}
	
	@GetMapping("/getById/{id}")
	public Optional<FeedBack> getById(@PathVariable("id") long id) {
		return feedBackRepository.findById(id);
	}
	
	@GetMapping("/getkByHomeworkId/{id}")
	public List<FeedBack> getFeedBackByHomeworkId(@PathVariable("id") long id) {
		return feedBackRepository.findByHomeworkId(id);
	}
	
}
