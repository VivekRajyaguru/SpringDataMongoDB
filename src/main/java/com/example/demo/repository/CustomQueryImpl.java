package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.example.demo.model.CustomClass;
import com.example.demo.model.Salary;
import com.example.demo.model.User;
import com.mongodb.BasicDBObject;
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

	@Override
	public int updateSalary(Salary salary) throws Exception {
		Query query  = new Query(Criteria.where("id").is(salary.getId()));
		Update update = new Update();
		update.set("amount", salary.getAmount());
		update.set("user_id", salary.getUser_id());
		
		UpdateResult result = mongoTemplate.updateFirst(query, update, Salary.class);
		if (result != null) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public List<CustomClass> getAllData(String id) throws Exception {
		LookupOperation lookUpOperation = LookupOperation.newLookup()
														 .from("salary").localField("_id").foreignField("user_id").as("salary");
		
		AggregationOperation match = Aggregation.match(Criteria.where("_id").is(id));
		
		Aggregation aggregation = Aggregation.newAggregation(match, lookUpOperation);
		List<CustomClass> results = mongoTemplate.aggregate(aggregation, "user", CustomClass.class).getMappedResults();
		return results;
	}
	
}
