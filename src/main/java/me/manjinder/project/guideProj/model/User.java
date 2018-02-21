package me.manjinder.project.guideProj.model;

import javax.xml.bind.annotation.XmlRootElement;

//@ Manjinder Singh - manjindersingh.me

@XmlRootElement
public class User {
	private int id;
	private String firstName;
	private String lastName;
	private String userType;
	private String email;
	
	public User() {
		
	}
	public User(int id, String firstName, String lastName, String userType, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userType = userType;
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	

}
