package com.esisa.back.office.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class DatabaseSequence {
	@Id
    private String id;
 
    private long seq;

    public DatabaseSequence() {
		// TODO Auto-generated constructor stub
	}
    
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getSeq() {
		return seq;
	}

	public void setSeq(long seq) {
		this.seq = seq;
	}
 
    
}
