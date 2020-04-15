package com.esisa.back.office.entities;

import java.time.LocalDateTime;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@org.springframework.data.mongodb.core.mapping.Document
public class Document {
	
	@Id
	private ObjectId id;
	private String title;
	private LocalDateTime dateTime;
	private ClassRoom classRoom;
	private Professor professor;
	private List<File> files;
	
	public Document() {
		// TODO Auto-generated constructor stub
	}

	public Document(String title, LocalDateTime dateTime, ClassRoom classRoom, Professor professor, List<File> files) {
		super();
		this.title = title;
		this.dateTime = dateTime;
		this.classRoom = classRoom;
		this.professor = professor;
		this.files = files;
	}

	public Document(ObjectId id, String title, LocalDateTime dateTime, ClassRoom classRoom, Professor professor,
			List<File> files) {
		super();
		this.id = id;
		this.title = title;
		this.dateTime = dateTime;
		this.classRoom = classRoom;
		this.professor = professor;
		this.files = files;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public ClassRoom getClassRoom() {
		return classRoom;
	}

	public void setClassRoom(ClassRoom classRoom) {
		this.classRoom = classRoom;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public List<File> getFiles() {
		return files;
	}

	public void setFiles(List<File> files) {
		this.files = files;
	}

}
