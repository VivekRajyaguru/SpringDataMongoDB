package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.example.demo.model.User;
import com.mongodb.client.result.UpdateResult;

public class CustomQueryImpl implements CustomQuery{

	@Autowired
	MongoTemplate mongoTemplate;
	
	@Override
	public int updateUser(User user) throws Exception {
		Query query  = new Query(Criteria.where("id").is(user.getId()));
		Update update = new Update();
		update.set("name", user.getName());
		update.set("password", user.getPassword());
		
		UpdateResult result = mongoTemplate.updateFirst(query, update, User.class);
		
		if (result != null) {
			return 1;
		} else {
			return 0;
		}
	}
	
	@Override
	public void saveBulkUser(List<User> user) throws Exception {
		mongoTemplate.insertAll(user);
	}
	
}
