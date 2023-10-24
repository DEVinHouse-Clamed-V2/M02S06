package org.senai.model;

public class Student {
	private Integer registration;
	private String name;
	private String email;

	public Student() {

	}

	public Student(Integer registration, String name, String email) {
		this.registration = registration;
		this.name = name;
		this.email = email;
	}

	public Integer getRegistration() {
		return registration;
	}

	public void setRegistration(Integer registration) {
		this.registration = registration;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
