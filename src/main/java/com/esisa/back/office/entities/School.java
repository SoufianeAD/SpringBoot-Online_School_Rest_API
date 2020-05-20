package com.esisa.back.office.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class School {
	
	@Transient
    public static final String SEQUENCE_NAME = "schools_sequence";
	
	@Id
	private long id;
	private String name;
	private String address;
	private String phone;
	private String webSite;
	
	public School() {
		// TODO Auto-generated constructor stub
	}

	public School(String name, String address, String phone, String webSite) {
		super();
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.webSite = webSite;
	}

	public School(long id, String name, String address, String phone, String webSite) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.webSite = webSite;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getWebSite() {
		return webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	@Override
	public String toString() {
		return "School [id=" + id + ", name=" + name + ", address=" + address + ", phone=" + phone + ", webSite="
				+ webSite + "]";
	}

}
