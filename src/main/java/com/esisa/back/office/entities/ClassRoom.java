package com.esisa.back.office.entities;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ClassRoom {
	
	@Id
	private ObjectId id;
	private String name;
	private String level;
	private School school;
	
	public ClassRoom() {
		// TODO Auto-generated constructor stub
	}

	public ClassRoom(String name, String level, School school) {
		super();
		this.name = name;
		this.level = level;
		this.school = school;
	}

	public ClassRoom(ObjectId id, String name, String level, School school) {
		super();
		this.id = id;
		this.name = name;
		this.level = level;
		this.school = school;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	
}
