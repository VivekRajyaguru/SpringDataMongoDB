package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Salary {

	@Id
	private String id;
	private Long amount;
	private String user_id;
	
	public Salary() {
		
	}
	
	public Salary(String id, Long amount, String user_id) {
		super();
		this.id = id;
		this.amount = amount;
		this.user_id = user_id;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	
	
	
	
}
