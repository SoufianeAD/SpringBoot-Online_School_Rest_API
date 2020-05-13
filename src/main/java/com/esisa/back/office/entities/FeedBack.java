package com.esisa.back.office.entities;

import java.time.LocalDateTime;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class FeedBack {
	
	@Id
	private ObjectId id;
	private LocalDateTime delivredDateTime;
	private Homework homework;
	private Student student;
	
	
	public FeedBack() {
		// TODO Auto-generated constructor stub
	}


	public FeedBack(LocalDateTime delivredDateTime, Homework homework, Student student) {
		super();
		this.delivredDateTime = delivredDateTime;
		this.homework = homework;
		this.student = student;
	}


	public FeedBack(ObjectId id, LocalDateTime delivredDateTime, Homework homework, Student student) {
		super();
		this.id = id;
		this.delivredDateTime = delivredDateTime;
		this.homework = homework;
		this.student = student;
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


	public Student getStudent() {
		return student;
	}


	public void setStudent(Student student) {
		this.student = student;
	}

	
}
