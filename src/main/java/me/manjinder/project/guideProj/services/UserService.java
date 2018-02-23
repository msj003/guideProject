package me.manjinder.project.guideProj.services;

import java.util.ArrayList;
import java.util.List;

import me.manjinder.project.guideProj.database.RdbUserImpl;
import me.manjinder.project.guideProj.model.User;

public class UserService {

	public List<User> getAllUsers(){
		List<User> usersList = new ArrayList<User>();
		RdbUserImpl rdbUser = new RdbUserImpl();
		try {
			usersList=rdbUser.findAll();
		}catch(Exception e) {
			System.out.println(e);
		}
// 	System.out.println("YUser Service "+usersList.get(0).getEmail());
		return usersList; 
	}
	
	
	public User getUserByName(String userName) {
		User user =null;
		RdbUserImpl rdbUser = new RdbUserImpl();
		try {
			user=rdbUser.findByUsername(userName);
		}catch(Exception e) {
			System.out.println(e);
		}
	//	System.out.println("Single user "+user.getEmail());
		return user;
	}
	
	public void addUser(User user) {
		RdbUserImpl rdbUser = new RdbUserImpl();
		try {
			rdbUser.insertUser(user);
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
}
