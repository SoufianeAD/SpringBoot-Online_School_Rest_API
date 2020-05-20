package com.esisa.back.office.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class File {
	
	@Transient
    public static final String SEQUENCE_NAME = "files_sequence";
	
	@Id
	private long id;
	private String title;
	private FileType type;
	private com.esisa.back.office.entities.Document document;
	private FeedBack feedBack;
	
	public File() {
		// TODO Auto-generated constructor stub
	}

	public File(String title, FileType type, com.esisa.back.office.entities.Document document, FeedBack feedBack) {
		super();
		this.title = title;
		this.type = type;
		this.document = document;
		this.feedBack = feedBack;
	}

	public File(long id, String title, FileType type, com.esisa.back.office.entities.Document document,
			FeedBack feedBack) {
		super();
		this.id = id;
		this.title = title;
		this.type = type;
		this.document = document;
		this.feedBack = feedBack;
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

	public FileType getType() {
		return type;
	}

	public void setType(FileType type) {
		this.type = type;
	}

	public com.esisa.back.office.entities.Document getDocument() {
		return document;
	}

	public void setDocument(com.esisa.back.office.entities.Document document) {
		this.document = document;
	}

	public FeedBack getFeedBack() {
		return feedBack;
	}

	public void setFeedBack(FeedBack feedBack) {
		this.feedBack = feedBack;
	}

	@Override
	public String toString() {
		return "File [id=" + id + ", title=" + title + ", type=" + type + ", document=" + document + ", feedBack="
				+ feedBack + "]";
	}


}
