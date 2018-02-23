package me.manjinder.project.guideProj.model;

import javax.xml.bind.annotation.XmlRootElement;

//@ Manjinder Singh - manjindersingh.me

@XmlRootElement
public class User {
	private int id;
	private String username;
	private String pass;
	private String firstName;
	private String lastName;
	private String userType;
	private String email;
	
	public User() {
		
	}
	
	
	//Constructor with Password field to be used only for user password operations
	public User(int id, String username, String pass, String firstName, String lastName, String userType,
			String email) {
		super();
		this.id = id;
		this.username = username;
		this.pass = pass;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userType = userType;
		this.email = email;
	}

	//Regular constructor. Objects do not have any sensitive information.
	public User(int id, String username, String firstName, String lastName, String userType, String email) {
		super();
		this.id = id;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userType = userType;
		this.email = email;
	}
	
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
