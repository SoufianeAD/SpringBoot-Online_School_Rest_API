package com.esisa.back.office.controllers;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import com.esisa.back.office.entities.Document;
import com.esisa.back.office.repositories.DocumentRepository;
import com.esisa.back.office.services.FilesService;
import com.esisa.back.office.services.SequenceGeneratorService;

@RestController
@CrossOrigin("*")
@RequestMapping("/document")
public class DocumentController {

	@Autowired
	private DocumentRepository documentRepository;
	
	@Autowired
	private FilesService filesService;
	
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;
	
	@PostMapping("/add")
	public Document add(@RequestBody Document document) {
		document.setId(sequenceGeneratorService.generateSequence(Document.SEQUENCE_NAME));
		document.setDateTime(LocalDateTime.now());
		return documentRepository.save(document);
	}
	
	@PostMapping("/upload")
	public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file) throws IOException {
		filesService.uploadFile(file, FilesService.DOCUMENT_DIRECTORY);
		return new ResponseEntity<>("File has been uploaded && stored!", HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public Document update(@RequestBody Document document) {
		return documentRepository.save(document);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") long id) {
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
	public Optional<Document> getById(@PathVariable("id") long id) {
		return documentRepository.findById(id);
	}
	
	@GetMapping("/getByClassRoomId/{id}")
	public List<Document> getByClassRoomId(@PathVariable("id") long id) {
		return documentRepository.findByClassRoomId(id);
	}
	
	@GetMapping("/download/{file}")
	public StreamingResponseBody download(HttpServletResponse response, @PathVariable("file") String file)  {
	        response.setContentType("text/html;charset=UTF-8");
	        response.setHeader("Content-Disposition", "attachment; filename=\"" + file +"\"");
	        try {
	        	return filesService.downloadFile(FilesService.DOCUMENT_DIRECTORY + "/" + file);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
	       
	}
	
}
