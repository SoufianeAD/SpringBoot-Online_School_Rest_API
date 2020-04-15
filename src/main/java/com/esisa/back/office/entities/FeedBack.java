package com.esisa.back.office.entities;

import java.time.LocalDateTime;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class FeedBack {
	
	@Id
	private ObjectId id;
	private LocalDateTime delivredDateTime;
	private Homework homework;
	private List<File> files;
	private List<Student> students;
	
	
	public FeedBack() {
		// TODO Auto-generated constructor stub
	}

	public FeedBack(LocalDateTime delivredDateTime, Homework homework, List<File> files, List<Student> students) {
		super();
		this.delivredDateTime = delivredDateTime;
		this.homework = homework;
		this.files = files;
		this.students = students;
	}

	public FeedBack(ObjectId id, LocalDateTime delivredDateTime, Homework homework, List<File> files,
			List<Student> students) {
		super();
		this.id = id;
		this.delivredDateTime = delivredDateTime;
		this.homework = homework;
		this.files = files;
		this.students = students;
	}

	public ObjectId getId() {
		return id;
	}


	public void setId(ObjectId id) {
		this.id = id;
	}

	public LocalDateTime getDelivredDateTime() {
		return delivredDateTime;
	}

	public void setDelivredDateTime(LocalDateTime delivredDateTime) {
		this.delivredDateTime = delivredDateTime;
	}

	public Homework getHomework() {
		return homework;
	}

	public void setHomework(Homework homework) {
		this.homework = homework;
	}

	public List<File> getFiles() {
		return files;
	}

	public void setFiles(List<File> files) {
		this.files = files;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
}
