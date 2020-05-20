package com.esisa.back.office.entities;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

@org.springframework.data.mongodb.core.mapping.Document
public class Document {
	
	@Transient
    public static final String SEQUENCE_NAME = "documents_sequence";
	
	@Id
	private long id;
	private String title;
	private LocalDateTime dateTime;
	private ClassRoom classRoom;
	private Professor professor;
	
	public Document() {
		// TODO Auto-generated constructor stub
	}

	public Document(String title, LocalDateTime dateTime, ClassRoom classRoom, Professor professor) {
		super();
		this.title = title;
		this.dateTime = dateTime;
		this.classRoom = classRoom;
		this.professor = professor;
	}

	public Document(long id, String title, LocalDateTime dateTime, ClassRoom classRoom, Professor professor) {
		super();
		this.id = id;
		this.title = title;
		this.dateTime = dateTime;
		this.classRoom = classRoom;
		this.professor = professor;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	@Override
	public String toString() {
		return "Document [id=" + id + ", title=" + title + ", dateTime=" + dateTime + ", classRoom=" + classRoom
				+ ", professor=" + professor + "]";
	}

}
