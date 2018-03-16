package com.example.demo.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

@RestController
@RequestMapping("/crud")
public class Controller {
	
	
	private UserService userService;
	private GridFsOperations gridFsOperations;
	@Autowired
	public Controller(UserService userService, GridFsOperations gridFsOperations) {
		this.userService = userService;
		this.gridFsOperations = gridFsOperations;
	}

	@RequestMapping(value = "/getUserList", method = RequestMethod.POST)
	public List<User> getUserList() throws Exception{
		
		return userService.listUser();
	}
	
	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public String saveUser(@RequestBody User user) throws Exception {
		userService.saveUser(user);
		return "User Saved SuccessFully.";
	}
	
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public String updateUser(@RequestBody User user) throws Exception {
		userService.updateUser(user);
		return "User Update SuccessFully.";
	}
	
	@RequestMapping(value = "/saveUserPic", method = RequestMethod.POST)
	public String saveUserPic(@RequestParam("mediaFile") MultipartFile file) throws Exception {
		DBObject data = new BasicDBObject();
		Optional<User> user = userService.findById("1");
		data.put("User", user);
		
		InputStream imageStream = new FileInputStream("D://Test.jpg");
		gridFsOperations.store(imageStream, "Test.jpg","image/jpeg", data);
		
		/*File userFile = new File("D://Test.jpg");
		if(userFile.exists()) userFile.createNewFile();
		file.transferTo(userFile);*/
		return "User Saved SuccessFully.";
	}
	
	@RequestMapping(value = "/bulkSave", method = RequestMethod.POST)
	public String bulkSave(@RequestBody List<User> user) throws Exception {
		userService.bulkSave(user);
		return "User Saved SuccessFully.";
	}
	
	@RequestMapping(value = "/findByName/{name}",method = RequestMethod.POST)
	public User findByUserName(@PathVariable("name") String name) throws Exception {
		return userService.findByUserName(name);
	}
		
}
