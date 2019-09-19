package com.assignment.userdetails.Repository;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.assignment.userdetails.Pojo.User;

/*import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.assignment.userdetails.Pojo.User;

@Repository
@Transactional
public interface UserRepository extends CrudRepository<User,Long>{
	 @Query(value = "SELECT * FROM user u WHERE u.username =?1",
	            nativeQuery=true
	    )
	    public User getByName(String username);
	 

	<S extends User> S saveAndFlush(S user);


	
	 

}
*/
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