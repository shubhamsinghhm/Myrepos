package com.assignment.userdetails.Repository;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.assignment.userdetails.Pojo.User;

/*import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.assignment.userdetails.Pojo.User;*/


/*@Repository
public class UserRepository {
	 @Autowired
	 private EntityManager entityManager;
	 
	 public UserRepository(){
	 }
    
	 @Transactional
	 public void save(User user) {

		entityManager.persist(user);
		
	}
     @Transactional
	 public User getByName(String username) throws NoResultException{
		User user=(User) entityManager.createQuery("Select u from User u where u.username like :UserName").setParameter("UserName",username).getSingleResult();
		return user;
	}
     
     @Transactional
	 @SuppressWarnings("unchecked")
	 public Iterable<User> findAll() throws NoResultException {
		List<User> list=entityManager.createQuery("Select u from User u",User.class).getResultList();
		return list;
	}
	 


	
}*/

//This is static repository created within the class
@Repository
public class UserRepository{
	
    private static ArrayList<User> list=new ArrayList<User>();
    static{
    	list.add(new User("Shu12","shubham","singh",25,"student","delhi"));
    	list.add(new User("ram12","ram","singh",26,"doctor","banglore"));
    }
    
     public void save(User user) {
		for(User userfromlist:list){
		if(user.getUsername().equals(userfromlist.getUsername())){
			return;
		   }
		}
		list.add(user);
		   }

       public User getByName(String username) {
		
		 for(User userfromlist:list){
			if(userfromlist.getUsername().equals(username)){
				return userfromlist;
			     }
			}
		return null;
	                      }

     public Iterable<User> findAll() {
		
		return list;
	  }
	
}