package me.manjinder.project.guideProj.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import me.manjinder.project.guideProj.model.User;
import me.manjinder.project.guideProj.services.UserService;

@Path("/user")
public class UserResource {
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<User> getAllUsers() {
	//	System.out.println("Get users "+" "+UserService.getAllUsers().get(0).getEmail());
		return UserService.getAllUsers();
	}
	
	@GET
	@Path("/{username}")
	@Produces(MediaType.APPLICATION_XML)
	public User getUserByName(@PathParam("username") String username) {
		System.out.println("Single user Resource");
		return UserService.getUserByName(username);
	}

}
