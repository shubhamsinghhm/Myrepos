package com.assignment.userdetails.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.userdetails.Pojo.User;
import com.assignment.userdetails.Repository.UserRepository;

@Service
public class ServiceLayer {
	@Autowired
	UserRepository repositoryLayer;

	public void save(User user) {
		//repositoryLayer.saveAndFlush( user);
		repositoryLayer.save(user);
	}

	public User getByName(String username) {
		return repositoryLayer.getByName(username);
		
	}

	public Iterable<User> getAllUsers() {
		return repositoryLayer.findAll();
		
	}
	
	

}
