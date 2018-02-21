package me.manjinder.project.guideProj.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import me.manjinder.project.guideProj.model.User;

//@ Manjinder Singh - manjindersingh.me
public class RdbUserImpl implements UserDao {

	private Statement statement = null;
	private ResultSet resultSet = null;
	private Connection conn =null;
	private int id;
	private String firstName;
	private String lastName;
	private String userType;
	private String email;
	
	
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		List<User> allUsers = new ArrayList<User>();
		try {
			conn =  RdbConnection.createConnection();
			statement = conn.createStatement();
			resultSet = statement
                    .executeQuery("select * from logins,users where logins.id=users.logins_id;");
			while(resultSet.next()) {
				id= resultSet.getInt(1);
				firstName= resultSet.getString(5);
				lastName=resultSet.getString(6);
				userType=resultSet.getString(8);
				email=resultSet.getString(7);
				User user = new User(id, firstName, lastName, userType, email);
				allUsers.add(user);
				
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return allUsers;
	}

	@Override
	public List<User> findByUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findByEmail() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

}
