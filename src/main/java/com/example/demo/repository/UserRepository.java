package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.demo.model.User;

public interface UserRepository extends MongoRepository<User, String>,CustomQuery{

	@Query("{name: ?0}")
	User findByName(String name) throws Exception;
	
}
