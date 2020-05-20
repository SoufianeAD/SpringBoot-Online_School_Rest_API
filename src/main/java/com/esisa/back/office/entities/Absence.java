package com.esisa.back.office.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Absence {
	
	@Transient
    public static final String SEQUENCE_NAME = "absences_sequence";
	
	@Id
	private long id;
	private Student student;
	private Session session;
	
	public Absence() {
		// TODO Auto-generated constructor stub
	}

	public Absence(Student student, Session session) {
		super();
		this.student = student;
		this.session = session;
	}

	public Absence(long id, Student student, Session session) {
		super();
		this.id = id;
		this.student = student;
		this.session = session;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public String toString() {
		return "Absence [id=" + id + ", student=" + student + ", session=" + session + "]";
	}

}
