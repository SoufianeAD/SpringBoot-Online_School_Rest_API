package com.esisa.back.office.controllers;

import java.io.IOException;
import java.util.Collections;
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

import com.esisa.back.office.entities.Document;
import com.esisa.back.office.entities.File;
import com.esisa.back.office.entities.FileType;
import com.esisa.back.office.repositories.FileRepository;
import com.esisa.back.office.services.FilesService;
import com.esisa.back.office.services.SequenceGeneratorService;

@RestController
@CrossOrigin("*")
@RequestMapping("/file")
public class FileController {
	
	@Autowired
	private FileRepository fileRepository;
	
	@Autowired
	private FilesService filesService;
	
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;
	
	@PostMapping("/add")
	public File add(@RequestBody File file) {
		file.setId(sequenceGeneratorService.generateSequence(Document.SEQUENCE_NAME));
		return fileRepository.save(file);
	}
	
	@PutMapping("/update")
	public File update(@RequestBody File file) {
		return fileRepository.save(file);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") long id) {
		File file = fileRepository.findById(id).orElse(null);
		if(file != null && file.getType() == FileType.Document) {
			try {
				filesService.removeFile(FilesService.DOCUMENT_DIRECTORY + java.io.File.separator + file.getTitle());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if(file != null && file.getType() == FileType.Homework) {
			try {
				filesService.removeFile(FilesService.HOMEWORK_DIRECTORY + java.io.File.separator + file.getTitle());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if(file != null && file.getType() == FileType.FeedBack) {
			try {
				filesService.removeFile(FilesService.FEEDBACK_DIRECTORY + java.io.File.separator + file.getTitle());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		fileRepository.deleteById(id);
	}
	
	@DeleteMapping("/deleteAll")
	public void deleteAll() {
		fileRepository.deleteAll();
	}
	
	@GetMapping("/getAll")
	public List<File> getAll() {
		return fileRepository.findAll();
	}
	
	@GetMapping("/getById/{id}")
	public Optional<File> getById(@PathVariable("id") long id) {
		return fileRepository.findById(id);
	}
	
	@GetMapping("/getByDocumentId/{id}")
	public List<File> getByDocumentId(@PathVariable("id") long id) {
		List<File> files = fileRepository.findByDocumentId(id);
		Collections.reverse(files);
		return files;
	}
	
	@GetMapping("/getByFeedBackId/{id}")
	public List<File> getByFeedBackId(@PathVariable("id") long id) {
		List<File> files = fileRepository.findByFeedBackId(id);
		Collections.reverse(files);
		return files;
	}
	
}
