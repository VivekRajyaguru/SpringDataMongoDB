package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.CustomClass;
import com.example.demo.model.Salary;
import com.example.demo.model.User;
import com.mongodb.BasicDBObject;

public interface CustomQuery {

	int updateUser(User user) throws Exception;
	int updateSalary(Salary salary) throws Exception;
	void saveBulkUser(List<User> user) throws Exception;
	List<CustomClass> getAllData(String id) throws Exception;
}
