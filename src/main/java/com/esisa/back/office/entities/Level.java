package com.esisa.back.office.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Level {
	
	@Transient
    public static final String SEQUENCE_NAME = "levels_sequence";
	
	@Id
	private long id;
	private String title;
	private School school;
	
	public Level() {
		// TODO Auto-generated constructor stub
	}

	public Level(String title, School school) {
		super();
		this.title = title;
		this.school = school;
	}

	public Level(long id, String title, School school) {
		super();
		this.id = id;
		this.title = title;
		this.school = school;
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

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	@Override
	public String toString() {
		return "Level [id=" + id + ", title=" + title + ", school=" + school + "]";
	}

}
