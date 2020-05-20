package com.esisa.back.office.entities;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class FeedBack {
	
	@Transient
    public static final String SEQUENCE_NAME = "feedBacks_sequence";
	
	@Id
	private long id;
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


	public FeedBack(long id, LocalDateTime delivredDateTime, Homework homework, Student student) {
		super();
		this.id = id;
		this.delivredDateTime = delivredDateTime;
		this.homework = homework;
		this.student = student;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
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


	@Override
	public String toString() {
		return "FeedBack [id=" + id + ", delivredDateTime=" + delivredDateTime + ", homework=" + homework + ", student="
				+ student + "]";
	}

}
