package com.esisa.back.office.entities;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Absence {
	
	@Id
	private ObjectId id;
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

	public Absence(ObjectId id, Student student, Session session) {
		super();
		this.id = id;
		this.student = student;
		this.session = session;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
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
	
}
