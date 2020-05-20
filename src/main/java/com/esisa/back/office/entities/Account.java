package com.esisa.back.office.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

 @Document
public class Account {

	@Transient
	public static final String SEQUENCE_NAME = "accounts_sequence";
	 
	@Id
	private long id;
	private String userName;
	private String password;
	private School school;
	
	public Account() {
		// TODO Auto-generated constructor stub
	}

	public Account(String userName, String password, School school) {
		super();
		this.userName = userName;
		this.password = password;
		this.school = school;
	}

	public Account(long id, String userName, String password, School school) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.school = school;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", userName=" + userName + ", password=" + password + ", school=" + school + "]";
	}

}
