package com.assignment.userdetails.Service;


import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.assignment.userdetails.Pojo.User;
import com.assignment.userdetails.Repository.UserRepository;

@Service
public class ServiceLayer {
	@Autowired
	UserRepository repositoryLayer;

	public void save(User user) {
		try{
			repositoryLayer.save(user);
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}

	public User getByName(String username) {
		User user=null;
		try{
		     user= repositoryLayer.getByName(username);
		}catch(NoResultException ex){
			System.out.println(ex.getMessage());
		}
		return user;
	}

	public Iterable<User> getAllUsers() {
		List<User> user=null;
		try{
		user= (List<User>) repositoryLayer.findAll();
		}catch(NoResultException ex){
			System.out.println(ex.getMessage());
		}
		return user;
	}
	
	

}
