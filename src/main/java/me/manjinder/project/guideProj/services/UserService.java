package me.manjinder.project.guideProj.services;

import java.util.ArrayList;
import java.util.List;

import me.manjinder.project.guideProj.database.RdbUserImpl;
import me.manjinder.project.guideProj.model.User;

public class UserService {

	public static List<User> getAllUsers(){
		List<User> usersList = new ArrayList<User>();
		RdbUserImpl rdbUser = new RdbUserImpl();
		try {
			usersList=rdbUser.findAll();
		}catch(Exception e) {
			
		}
	System.out.println("YUser Service "+usersList.get(0).getEmail());
		return usersList; 
	}
}