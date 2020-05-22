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

import com.esisa.back.office.entities.FeedBack;
import com.esisa.back.office.entities.File;
import com.esisa.back.office.repositories.FeedBackRepository;
import com.esisa.back.office.repositories.FileRepository;
import com.esisa.back.office.services.FilesService;
import com.esisa.back.office.services.SequenceGeneratorService;

@RestController
@CrossOrigin("*")
@RequestMapping("/feedBack")
public class FeedBackController {
	
	@Autowired
	private FeedBackRepository feedBackRepository;
	
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;
	
	@Autowired
	private FilesService filesService;
	
	@Autowired
	private FileRepository fileRepository;
	
	@PostMapping("/add")
	public FeedBack add(@RequestBody FeedBack feedBack) {
		feedBack.setId(sequenceGeneratorService.generateSequence(FeedBack.SEQUENCE_NAME));
		feedBack.setDelivredDateTime(LocalDateTime.now());
		return feedBackRepository.save(feedBack);
	}
	
	@PostMapping("/upload")
	public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file) throws IOException {
		filesService.uploadFile(file, FilesService.FEEDBACK_DIRECTORY);
		return new ResponseEntity<>("File has been uploaded && stored!", HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public FeedBack update(@RequestBody FeedBack feedBack) {
		return feedBackRepository.save(feedBack);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") long id) {
		List<File> files = fileRepository.findByFeedBackId(id);
		for (File file : files) {
			try {
				filesService.removeFile(FilesService.FEEDBACK_DIRECTORY + java.io.File.separator + file.getTitle());
				fileRepository.deleteById(file.getId());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
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
	
	@GetMapping("/getByHomeworkId/{id}")
	public List<FeedBack> getFeedBackByHomeworkId(@PathVariable("id") long id) {
		return feedBackRepository.findByHomeworkId(id);
	}
	
	@GetMapping("/getByHomeworkIdAndStudentId/{id_homework}/{id_student}")
	public FeedBack getByHomeworkIdAndStudentId(@PathVariable("id_homework") long idHomework, @PathVariable("id_student") long idStudent) {
		return feedBackRepository.findByHomeworkIdAndStudentId(idHomework, idStudent);
	}
	
	@GetMapping("/download/{file}")
	public StreamingResponseBody download(HttpServletResponse response, @PathVariable("file") String file)  {
	        response.setContentType("text/html;charset=UTF-8");
	        response.setHeader("Content-Disposition", "attachment; filename=\"" + file +"\"");
	        try {
	        	return filesService.downloadFile(FilesService.FEEDBACK_DIRECTORY + "/" + file);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
	       
	}
	
}
