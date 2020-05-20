package com.esisa.back.office.entities;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Session {

	@Transient
    public static final String SEQUENCE_NAME = "sessions_sequence";
	
	@Id
	private long id;
	private LocalDateTime dateTime;
	private String idSession;
	private String password;
	private String url;
	private ClassRoom classRoom;
	private Professor professor;
	
	public Session() {
		// TODO Auto-generated constructor stub
	}

	public Session(LocalDateTime dateTime, String idSession, String password, String url, ClassRoom classRoom,
			Professor professor) {
		super();
		this.dateTime = dateTime;
		this.idSession = idSession;
		this.password = password;
		this.url = url;
		this.classRoom = classRoom;
		this.professor = professor;
	}

	public Session(long id, LocalDateTime dateTime, String idSession, String password, String url, ClassRoom classRoom,
			Professor professor) {
		super();
		this.id = id;
		this.dateTime = dateTime;
		this.idSession = idSession;
		this.password = password;
		this.url = url;
		this.classRoom = classRoom;
		this.professor = professor;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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
		return "Session [id=" + id + ", dateTime=" + dateTime + ", idSession=" + idSession + ", password=" + password
				+ ", url=" + url + ", classRoom=" + classRoom + ", professor=" + professor + "]";
	}

}
