package com.esisa.back.office.entities;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Level {
	
	@Id
	private ObjectId id;
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

	public Level(ObjectId id, String title, School school) {
		super();
		this.id = id;
		this.title = title;
		this.school = school;
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

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

}
