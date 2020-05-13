package com.esisa.back.office.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
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

import com.esisa.back.office.entities.Student;
import com.esisa.back.office.repositories.LevelRepository;
import com.esisa.back.office.repositories.StudentRepository;
import com.esisa.back.office.services.FilesService;

@RestController
@CrossOrigin("*")
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private LevelRepository levelRepository;
	
	@Autowired
	private FilesService filesService;
	
	@PostMapping("/add")
	public Student add(@RequestBody Student student) {
		return studentRepository.save(student);
	}
	
	@PostMapping("/importByLevel/{id}")
	public List<Student> upload(@PathVariable("id") ObjectId id, @RequestParam("file") MultipartFile file) throws IOException {
		List<Student> students = filesService.importSudents(file, FilesService.IMPORT_STUDENTS_DIRECTORY, levelRepository.findById(id).orElse(null));
		for (Student student : students) {
			studentRepository.save(student);
		}
		return studentRepository.findAll();
	}
	
	@PutMapping("/update")
	public Student update(@RequestBody Student student) {
		return studentRepository.save(student);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") ObjectId id) {
		studentRepository.deleteById(id);
	}
	
	@DeleteMapping("/deleteAll")
	public void deleteAll() {
		studentRepository.deleteAll();
	}
	
	@GetMapping("/getAll")
	public List<Student> getAll() {
		return studentRepository.findAll();
	}
	
	@GetMapping("/getById/{id}")
	public Optional<Student> getById(@PathVariable("id") ObjectId id) {
		return studentRepository.findById(id);
	}
	
	@GetMapping("/getByLevelId/{id}")
	public List<Student> getByLevelId(@PathVariable("id") ObjectId id) {
		return studentRepository.findByLevelId(id);
	}
}
