package com.practise.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practise.entities.User;
import com.practise.service.UserService;

@RestController
@RequestMapping("/user/controller")
public class UserController 
{
	@Autowired
   private UserService userService;
	
	@GetMapping("/get")
	public ResponseEntity<User> returnUser(@RequestParam int id)
	{
		User userById = userService.getUserById(id);
		return new ResponseEntity<User>(userById,HttpStatusCode.valueOf(200));
		
	}
	
	@GetMapping("/getAllUsers")
	public ResponseEntity<List<User>> returnAllUsers()
	{
		List<User> allUsers = userService.getAllUsers();
		return new ResponseEntity<List<User>>(allUsers,HttpStatusCode.valueOf(200));
	}
	
	@PostMapping("/create")
	public ResponseEntity<User> createUser(@RequestBody User user)
	{
		User saveUser = userService.saveUser(user);
		return new ResponseEntity<User>(saveUser,HttpStatusCode.valueOf(201));
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<User> updateUser(@PathVariable int id,@RequestBody User user)
	{
		User updateUser = userService.updateUser(id,user);
		return new ResponseEntity<User>(updateUser,HttpStatusCode.valueOf(201));
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteUser(@RequestParam int id)
	{
		String deleteUser = userService.deleteUser(id);
		return new ResponseEntity<String>(deleteUser,HttpStatusCode.valueOf(201));
	}
	
}
