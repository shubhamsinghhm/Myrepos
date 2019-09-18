package com.assignment.userdetails.Repository;

import org.springframework.data.jpa.repository.Modifying;
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
