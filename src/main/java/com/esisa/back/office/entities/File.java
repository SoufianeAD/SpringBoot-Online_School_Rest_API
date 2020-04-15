package com.esisa.back.office.entities;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class File {
	
	@Id
	private ObjectId id;
	private String title;
	private String file;//path and file name
	
	public File() {
		// TODO Auto-generated constructor stub
	}

	public File(String title, String file) {
		super();
		this.title = title;
		this.file = file;
	}

	public File(ObjectId id, String title, String file) {
		super();
		this.id = id;
		this.title = title;
		this.file = file;
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

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}
	
}
