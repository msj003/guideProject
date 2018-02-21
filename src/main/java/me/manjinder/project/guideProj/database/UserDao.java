package me.manjinder.project.guideProj.database;

import java.util.List;

import me.manjinder.project.guideProj.model.User;
//@ Manjinder Singh - manjindersingh.me
interface UserDao {
	List<User> findAll();
    List<User> findByUsername();
    List<User> findByEmail();
    
    boolean insertUser(User user);
    boolean updateUser(User user);
    boolean deleteUser(User user);
    
}
