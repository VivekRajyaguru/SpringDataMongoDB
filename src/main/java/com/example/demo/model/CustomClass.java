package com.example.demo.model;

import java.util.List;

public class CustomClass {

	private String id;
	private String name;
	private String password;
	private String email;
	private String company;
	private List<Object> salary;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public List<Object> getSalary() {
		return salary;
	}
	public void setSalary(List<Object> salary) {
		this.salary = salary;
	}
	public CustomClass(String id, String name, String password, String email, String company, List<Object> salary) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.company = company;
		this.salary = salary;
	}
	public CustomClass() {
		super();
	}
	
	
	
}
