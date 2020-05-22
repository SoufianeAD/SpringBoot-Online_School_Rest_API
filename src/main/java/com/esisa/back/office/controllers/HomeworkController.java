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

import com.esisa.back.office.entities.File;
import com.esisa.back.office.entities.Homework;
import com.esisa.back.office.repositories.FileRepository;
import com.esisa.back.office.repositories.HomeworkRepository;
import com.esisa.back.office.services.FilesService;
import com.esisa.back.office.services.SequenceGeneratorService;

@RestController
@CrossOrigin("*")
@RequestMapping("/homework")
public class HomeworkController {

	@Autowired
	private HomeworkRepository homeworkRepository;
	
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;
	
	@Autowired
	private FileRepository fileRepository;
	
	@Autowired
	private FilesService filesService;
	
	@PostMapping("/add")
	public Homework add(@RequestBody Homework homework) {
		homework.setId(sequenceGeneratorService.generateSequence(Homework.SEQUENCE_NAME));
		homework.setDateTime(LocalDateTime.now());
		return homeworkRepository.save(homework);
	}
	
	@PostMapping("/upload")
	public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file) throws IOException {
		filesService.uploadFile(file, FilesService.HOMEWORK_DIRECTORY);
		return new ResponseEntity<>("File has been uploaded && stored!", HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public Homework update(@RequestBody Homework homework) {
		return homeworkRepository.save(homework);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") long id) {
		List<File> files = fileRepository.findByDocumentId(id);
		for (File file : files) {
			try {
				filesService.removeFile(FilesService.HOMEWORK_DIRECTORY + java.io.File.separator + file.getTitle());
				fileRepository.deleteById(file.getId());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		homeworkRepository.deleteById(id);
	}
	
	@DeleteMapping("/deleteAll")
	public void deleteAll() {
		homeworkRepository.deleteAll();
	}
	
	@GetMapping("/getAll")
	public List<Homework> getAll() {
		return homeworkRepository.findAll();
	}
	
	@GetMapping("/getById/{id}")
	public Optional<Homework> getById(@PathVariable("id") long id) {
		return homeworkRepository.findById(id);
	}
	
	@GetMapping("/getByClassRoomId/{id}")
	public List<Homework> getByClassRoomId(@PathVariable("id") long id) {
		return homeworkRepository.findByClassRoomId(id);
	}
	
	@GetMapping("/download/{file}")
	public StreamingResponseBody download(HttpServletResponse response, @PathVariable("file") String file)  {
	        response.setContentType("text/html;charset=UTF-8");
	        response.setHeader("Content-Disposition", "attachment; filename=\"" + file +"\"");
	        try {
	        	return filesService.downloadFile(FilesService.HOMEWORK_DIRECTORY + "/" + file);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
	       
	}
	
}
