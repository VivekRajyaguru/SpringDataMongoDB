package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.User;

public interface UserService {

	void saveUser(User user) throws Exception;
	
	void updateUser(User user) throws Exception;
	
	List<User> listUser() throws Exception;
	
	Optional<User> findById(String userId) throws Exception;
	
	void bulkSave(List<User> user) throws Exception;
	
	User findByUserName(String name) throws Exception;
	
}
