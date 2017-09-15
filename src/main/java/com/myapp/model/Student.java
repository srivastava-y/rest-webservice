package com.myapp.model;

public class Student {

	private String name;
	private int rollNo;
	private String address;
	private String email;
	
	public Student(String name, int rollNo, String address, String email) {
		this.name = name;
		this.rollNo = rollNo;
		this.address = address;
		this.email = email;
	}
	
	public Student() {
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
