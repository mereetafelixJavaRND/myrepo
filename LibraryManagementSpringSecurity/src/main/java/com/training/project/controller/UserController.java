package com.training.project.controller;


import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.training.project.model.User;
import com.training.project.service.UserService;

@RestController
@RequestMapping("/api/v2/lms")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/add-user")
	public ResponseEntity<String> addBook(@Valid @RequestBody User user) {

		user.setUserId(0);
		userService.save(user);
		return new ResponseEntity<>("User Added Successfully!!"+new Gson().toJson(user), HttpStatus.OK);

	}

	@PutMapping("/update-user/{id}")
	public ResponseEntity<String> updateBook(@PathVariable int id,@Valid @RequestBody User user) {

		Optional<User> userOpt = userService.getUserById(id);
		User user1 = userOpt.get();
		if(user1 == null){

			return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);

		}
		userService.save(user);
		return new ResponseEntity<>("User Updated Successfully!!"+new Gson().toJson(user), HttpStatus.OK);

	}

	@DeleteMapping("/delete-user/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable int id){

		Optional<User> userOpt = userService.getUserById(id);
		User user = userOpt.get();
		if(user == null){

			return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);

		}
		userService.deleteUser(id);
		return new ResponseEntity<>("User Deleted Successfully!!", HttpStatus.OK);

	}

}
