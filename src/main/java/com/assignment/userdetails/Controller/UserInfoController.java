package com.assignment.userdetails.Controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.assignment.userdetails.Pojo.User;
import com.assignment.userdetails.Service.ServiceLayer;
import com.assignment.userdetails.setView.PdfReportView;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserInfoController {
	
	@Autowired
	private ServiceLayer service;
	
	@PostMapping(path="/users")
	public ResponseEntity<Void> saveUsers ( @RequestBody User user){
		
		service.save(user);
        URI uri=ServletUriComponentsBuilder.fromCurrentRequest().path("/{username}").buildAndExpand(user.getUsername()).toUri();
		
		return ResponseEntity.created(uri).build();
		
		}
	
	@GetMapping(path="/users/{username}",produces="application/json")
	public ResponseEntity<User> getUsers (@PathVariable String username){
		
		User  user=service.getByName(username);
		if(user==null){
			return ResponseEntity.badRequest().build();
		
		}
		return ResponseEntity.ok(user);
	}
	
	@GetMapping(path="/users/generatepdf",produces="application/pdf")
	public ModelAndView getAllUsers (){
		
		List<User>  user=(List<User>) service.getAllUsers();
		if(user==null){
			return new ModelAndView("error",HttpStatus.BAD_REQUEST);
		
		}
		return new ModelAndView(new PdfReportView(),"userList",user);
	}
	
	
}
