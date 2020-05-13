package com.esisa.back.office.entities;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ClassRoom {
	
	@Id
	private ObjectId id;
	private String name;
	private Level level;
	
	public ClassRoom() {
		// TODO Auto-generated constructor stub
	}

	public ClassRoom(String name, Level level) {
		super();
		this.name = name;
		this.level = level;
	}

	public ClassRoom(ObjectId id, String name, Level level) {
		super();
		this.id = id;
		this.name = name;
		this.level = level;
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

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

}
