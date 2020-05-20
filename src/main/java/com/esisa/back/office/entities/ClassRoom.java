package com.esisa.back.office.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ClassRoom {
	
	@Transient
    public static final String SEQUENCE_NAME = "classRooms_sequence";
	
	@Id
	private long id;
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

	public ClassRoom(long id, String name, Level level) {
		super();
		this.id = id;
		this.name = name;
		this.level = level;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	@Override
	public String toString() {
		return "ClassRoom [id=" + id + ", name=" + name + ", level=" + level + "]";
	}

}
