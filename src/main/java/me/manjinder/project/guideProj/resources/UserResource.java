package me.manjinder.project.guideProj.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import me.manjinder.project.guideProj.model.User;
import me.manjinder.project.guideProj.services.UserService;

@Path("/user")
public class UserResource {
	
	UserService userService = new UserService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getAllUsers() {
	//	System.out.println("Get users "+" "+UserService.getAllUsers().get(0).getEmail());
		return userService.getAllUsers();
	}
	
	@GET
	@Path("/{username}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUserByName(@PathParam("username") String username) {
//		System.out.println("Single user Resource");
		return userService.getUserByName(username);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void addUser(User user) {
		userService.addUser(user);
	}

}
