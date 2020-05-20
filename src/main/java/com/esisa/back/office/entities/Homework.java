package com.esisa.back.office.entities;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Homework extends com.esisa.back.office.entities.Document {
	
	private LocalDateTime delivringDateTime;
	
	public Homework() {
		// TODO Auto-generated constructor stub
	}

	public Homework(LocalDateTime delivringDateTime) {
		super();
		this.delivringDateTime = delivringDateTime;
	}

	public LocalDateTime getDelivringDateTime() {
		return delivringDateTime;
	}

	public void setDelivringDateTime(LocalDateTime delivringDateTime) {
		this.delivringDateTime = delivringDateTime;
	}

	@Override
	public String toString() {
		return "Homework [delivringDateTime=" + delivringDateTime + "]";
	}
	
}
