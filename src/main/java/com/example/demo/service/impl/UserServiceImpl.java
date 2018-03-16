package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	private UserRepository userRepo;
	@Autowired
	public UserServiceImpl(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	@Override
	public void saveUser(User user) throws Exception {
		userRepo.save(user);
	}

	@Override
	public void updateUser(User user) throws Exception {
		userRepo.updateUser(user);
	}

	@Override
	public List<User> listUser() throws Exception {
		return userRepo.findAll();
	}

	@Override
	public Optional<User> findById(String userId) throws Exception {
		return userRepo.findById(userId);
	}

	@Override
	public void bulkSave(List<User> user) throws Exception {
		userRepo.saveBulkUser(user);
		
	}

	@Override
	public User findByUserName(String name) throws Exception {
		return userRepo.findByName(name);
	}

}
