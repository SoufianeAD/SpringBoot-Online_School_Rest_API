package com.esisa.back.office.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Student {
	
	@Transient
    public static final String SEQUENCE_NAME = "documents_sequence";
	
	@Id
	private long id;
	private String cne;
	private String firstName;
	private String lastName;
	private String phone;
	private String email;
	private String address;
	private Level level;
	private Account account;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String cne, String firstName, String lastName, String phone, String email, String address,
			Level level, Account account) {
		super();
		this.cne = cne;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.level = level;
		this.account = account;
	}

	public Student(long id, String cne, String firstName, String lastName, String phone, String email, String address,
			Level level, Account account) {
		super();
		this.id = id;
		this.cne = cne;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.level = level;
		this.account = account;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCne() {
		return cne;
	}

	public void setCne(String cne) {
		this.cne = cne;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", cne=" + cne + ", firstName=" + firstName + ", lastName=" + lastName + ", phone="
				+ phone + ", email=" + email + ", address=" + address + ", level=" + level + ", account=" + account
				+ "]";
	}

}
