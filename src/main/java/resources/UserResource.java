package resources;

import javax.servlet.ServletContext;
import javax.ws.rs.CookieParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import model.Repository;
import model.Token;
import model.User;

@Path("/users")
public class UserResource {

	@Context
	private ServletContext context;
	
	@POST
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public User registerUser(@FormParam("nickName") String nickName,
							 @FormParam("firstName") String firstName,
							 @FormParam("lastName") String lastName,
							 @FormParam("passWord") String passWord) {
		User user = new User(lastName, firstName, nickName, passWord);
		Repository.addUser(user);
		return user;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response getUsers(@CookieParam("token") String token) {
		if(!Token.isAuthenticated(token)) {
			return Response.status(Status.UNAUTHORIZED).build();
		}
		return Response.ok(Repository.getUsers()).build();
	}
	
	@POST
	@Path("/login")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response login(@FormParam("nickName") String nickname, 
					      @FormParam("passWord") String password) {
		User user = Repository.getUserByName(nickname);
		if(user != null && user.getPassWord().equals(password)) {
			String token = Token.createToken();
			Repository.addToken(token, user);
			NewCookie cookie = new NewCookie("token", token, "/", null, null, Integer.MAX_VALUE, false);
			return Response.ok().cookie(cookie).build();
		}
		return Response.status(Status.UNAUTHORIZED).build();		
	}
}
