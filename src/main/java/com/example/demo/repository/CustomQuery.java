package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.User;

public interface CustomQuery {

	int updateUser(User user) throws Exception;
	void saveBulkUser(List<User> user) throws Exception;
}
