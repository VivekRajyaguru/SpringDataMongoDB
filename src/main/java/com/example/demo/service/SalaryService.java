package com.example.demo.service;

import java.util.List;

import com.example.demo.model.CustomClass;
import com.example.demo.model.Salary;
import com.mongodb.BasicDBObject;


public interface SalaryService {
	
	void saveUserSalary(Salary object) throws Exception;
	
	void updateUserSalary(Salary object) throws Exception;
	
	List<CustomClass> getData(String id) throws Exception;

}
