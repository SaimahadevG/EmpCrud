package com.practise.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practise.entities.User;
import com.practise.repository.UserRepository;

@Service
public class UserService
{
	@Autowired
   private UserRepository userRepository;
	
	public List<User> getAllUsers()
	{
	  List<User> all = userRepository.findAll();
		return all;
	}
	
	public User getUserById(int id)
	{ 
		 Optional<User> byId = userRepository.findById(id);
		 User user = byId.get();
		 return user;
	}
	
	public User saveUser(User user)
	{
		User save = userRepository.save(user);
		return save;
	}
	
	public User updateUser(int id,User user)
	{
		Optional<User> byId = userRepository.findById(id);
		User user2 = byId.get();
		user2.setAge(user.getAge());
		user2.setName(user.getName());
		user2.setStudying(user.getStudying());
		User save = userRepository.save(user2);
		return save;
	}
	
	public String deleteUser(int id)
	{
		userRepository.deleteById(id);
		return "deleted";
	}
	
}
