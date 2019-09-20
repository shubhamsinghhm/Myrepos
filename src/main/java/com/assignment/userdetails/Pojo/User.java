package com.assignment.userdetails.Pojo;
/*import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
*/
//@Entity
//@Table(name="User")
public class User {
	
	//@Id
	//@Column(length=50)
	private String username;
	//@Column
	private String first_name;
	//@Column
	private String last_name;
	//@Column
	private int age;
	//@Column
	private String occupation;
	//@Column
	private String address;
	
	
	
	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getFirst_name() {
		return first_name;
	}



	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}



	public String getLast_name() {
		return last_name;
	}



	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public String getOccupation() {
		return occupation;
	}



	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public User(String username, String first_name, String last_name, int age, String occupation, String address) {
		super();
		this.username = username;
		this.first_name = first_name;
		this.last_name = last_name;
		this.age = age;
		this.occupation = occupation;
		this.address = address;
	}



	protected User(){
		
	}



	@Override
	public String toString() {
		return "User [, username=" + username + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", age=" + age + ", occupation=" + occupation + ", address=" + address + "]";
	}
	
	
}

