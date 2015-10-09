package resources;

import javax.ws.rs.CookieParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import util.ExceptionWrapper;
import model.Movie;
import model.Rating;
import model.Repository;
import model.Token;
import model.User;

@Path("/movies")
public class MovieResource {

	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response getMovies(@CookieParam("token") String token) {
		if(!Token.isAuthenticated(token)) {
			return Response.status(Status.UNAUTHORIZED).build();
		}
		return Response.ok(Repository.getMovies()).build();
	}
	
	@POST
	@Path("/{id}/rate")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response addMovieRating(@CookieParam("token") String token, @PathParam("id") String id, @FormParam("rating") int rating) {
		if(!Token.isAuthenticated(token)) {
			return Response.status(Status.UNAUTHORIZED).build();
		}
		Movie movie = Repository.getMovieById(id);
		if(movie == null || rating < 1 || rating > 10) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		Rating userRating = new Rating(rating);
		User user = Repository.getUserByToken(token);
		try {
			Repository.addUserRating(user, movie, userRating);
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST).entity(new ExceptionWrapper(e)).build();
		}
		return Response.ok().build();
	}
	
	@PUT
	@Path("/{id}/rate")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response updateMovieRating(@CookieParam("token") String token, @PathParam("id") String id, @FormParam("rating") int rating) {
		if(!Token.isAuthenticated(token)) {
			return Response.status(Status.UNAUTHORIZED).build();
		}
		Movie movie = Repository.getMovieById(id);
		if(movie == null || rating < 1 || rating > 10) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		Rating userRating = new Rating(rating);
		User user = Repository.getUserByToken(token);
		try {
			Repository.updateUserRating(user, movie, userRating);
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST).entity(new ExceptionWrapper(e)).build();
		}
		return Response.ok().build();
	}
	
	@DELETE
	@Path("/{id}/rate")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response removeMovieRating(@CookieParam("token") String token, @PathParam("id") String id) throws Exception {
		if(!Token.isAuthenticated(token)) {
			return Response.status(Status.UNAUTHORIZED).build();
		}
		Movie movie = Repository.getMovieById(id);
		if(movie == null) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		User user = Repository.getUserByToken(token);
		try {
			Repository.removeUserRating(user, movie);
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST).entity(new ExceptionWrapper(e)).build();
		}
		return Response.ok().build();
	}	
}
