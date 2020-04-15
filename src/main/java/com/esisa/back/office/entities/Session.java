package com.esisa.back.office.entities;

import java.time.LocalDate;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Session {

	@Id
	private ObjectId id;
	private LocalDate start;
	private LocalDate end;
	private LocalDate date;
	private String idSession;
	private String password;
	private ClassRoom classRoom;
	private Professor professor;
	
	public Session() {
		// TODO Auto-generated constructor stub
	}

	public Session(LocalDate start, LocalDate end, LocalDate date, String idSession, String password,
			ClassRoom classRoom, Professor professor) {
		super();
		this.start = start;
		this.end = end;
		this.date = date;
		this.idSession = idSession;
		this.password = password;
		this.classRoom = classRoom;
		this.professor = professor;
	}

	public Session(ObjectId id, LocalDate start, LocalDate end, LocalDate date, String idSession, String password,
			ClassRoom classRoom, Professor professor) {
		super();
		this.id = id;
		this.start = start;
		this.end = end;
		this.date = date;
		this.idSession = idSession;
		this.password = password;
		this.classRoom = classRoom;
		this.professor = professor;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public LocalDate getStart() {
		return start;
	}

	public void setStart(LocalDate start) {
		this.start = start;
	}

	public LocalDate getEnd() {
		return end;
	}

	public void setEnd(LocalDate end) {
		this.end = end;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getIdSession() {
		return idSession;
	}

	public void setIdSession(String idSession) {
		this.idSession = idSession;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
	
	
}
