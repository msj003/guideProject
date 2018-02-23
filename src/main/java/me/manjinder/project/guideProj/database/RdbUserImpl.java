package me.manjinder.project.guideProj.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import me.manjinder.project.guideProj.model.User;

//@ Manjinder Singh - manjindersingh.me
public class RdbUserImpl implements UserDao {

	private Statement statement = null;
	private PreparedStatement prepStmt = null;
	private ResultSet resultSet = null;
	private Connection conn =null;
	private int id;
	private String firstName;
	private String lastName;
	private String userType;
	private String email;
	private String username;
	
	
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
				username= resultSet.getString(2);
				firstName= resultSet.getString(5);
				lastName=resultSet.getString(6);
				userType=resultSet.getString(8);
				email=resultSet.getString(7);
				User user = new User(id, username,firstName, lastName, userType, email);
				allUsers.add(user);
				
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return allUsers;
	}

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		User user =null;
		try {
			conn =  RdbConnection.createConnection();
			prepStmt = conn.prepareStatement("select * from logins,users where logins.id=users.logins_id and username=?");
			prepStmt.setString(1, username);
			resultSet = prepStmt
                    .executeQuery();
			while(resultSet.next()) {
				id= resultSet.getInt(1);
				username= resultSet.getString(2);
				firstName= resultSet.getString(5);
				lastName=resultSet.getString(6);
				userType=resultSet.getString(8);
				email=resultSet.getString(7);
				user = new User(id,username, firstName, lastName, userType, email);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return user;
	}

	@Override
	public List<User> findByEmail() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertUser(User user) {
		// TODO Auto-generated method stub
		try {
			conn =  RdbConnection.createConnection();
			
			// Inserting into logins table. 
			
			prepStmt = conn.prepareStatement("INSERT into logins(username,password) values(?,?);");
			prepStmt.setString(1, user.getUsername());
			prepStmt.setString(2,user.getPass());
			prepStmt.executeUpdate();
			
			//To get the auto-incremented id from logins table and insert as foreign key to users table

			prepStmt=conn.prepareStatement("Select id from logins where username=?;");
			prepStmt.setString(1, user.getUsername());
			resultSet=prepStmt.executeQuery();
			int id=1;
			while(resultSet.next()) {
				id = resultSet.getInt(1);	
			}
			prepStmt = conn.prepareStatement("INSERT into users(first_name,last_name,email,type,logins_id) values(?,?,?,?,?);");
			prepStmt.setString(1, user.getFirstName());
			prepStmt.setString(2, user.getLastName());
			prepStmt.setString(3, user.getEmail());
			prepStmt.setString(4, user.getUserType());
			prepStmt.setInt(5, id);
			prepStmt.executeUpdate();
		}catch(Exception e) {
			System.out.println(e);
		}
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
