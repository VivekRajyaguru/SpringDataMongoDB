package com.example.demo;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@SpringBootApplication
public class SpringBootMongoDbApplication {

	@Autowired
	private UserRepository userRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootMongoDbApplication.class, args);
	}
	
/*	@Bean
	InitializingBean saveData() {
		return () -> {
			userRepo.save(new User("1", "Vivek","Vivek123"));
			userRepo.save(new User("2", "Admin","Admin123"));
		};
	}*/
	
	
}
