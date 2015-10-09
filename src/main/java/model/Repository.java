package model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class Repository {
	
	private static final Map<String, Movie> MOVIES = new HashMap<String, Movie>();
	private static final Map<String, User> USERS = new HashMap<String, User>();
	private static final Map<String, User> AUTHORIZED_USERS = new HashMap<String, User>();
	private static final Map<User, Map<Movie, Rating>> USER_RATINGS = new HashMap<User, Map<Movie, Rating>>();

	public static void initialize() {
		MOVIES.put("tt0137523", new Movie(1, "tt0137523", "Fight Club", "1999", 139, "David Fincher",
				"An insomniac office worker, looking for a way to change his life, crosses paths with a devil-may-care soap maker, forming an underground fight club that evolves into something much, much more..."));
		MOVIES.put("tt2713180", new Movie(2, "tt2713180", "Fury", "2014", 134, "David Ayer",
				"April, 1945. As the Allies make their final push in the European Theatre, a battle-hardened Army sergeant named Wardaddy commands a Sherman tank and his five-man crew on a deadly mission behind enemy lines. Outnumbered, out-gunned, and with a rookie soldier thrust into their platoon, Wardaddy and his men face overwhelming odds in their heroic attempts to strike at the heart of Nazi Germany."));
		MOVIES.put("tt0111161", new Movie(3, "tt0111161", "The Shawshank Redemption", "1994", 142, "Frank Darabont",
				"Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency."));
		MOVIES.put("tt0468569", new Movie(4, "tt0468569", "The Dark Knight", "2008", 152, "Christopher Nolan",
				"When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, the caped crusader must come to terms with one of the greatest psychological tests of his ability to fight injustice."));
		MOVIES.put("tt0372784", new Movie(5, "tt0372784", "Batman Begins", "2005", 140, "Christopher Nolan",
				"After training with his mentor, Batman begins his war on crime to free the crime-ridden Gotham City from corruption that the Scarecrow and the League of Shadows have cast upon it."));
		MOVIES.put("tt1345836", new Movie(6, "tt1345836", "The Dark Knight Rises", "2012", 165, "Christopher Nolan",
				"Eight years after the Joker's reign of anarchy, the Dark Knight is forced to return from his imposed exile to save Gotham City from the brutal guerrilla terrorist Bane with the help of the enigmatic Catwoman."));
		
		USERS.put("henkie", new User("de Tester", "Henk", "henkie", "password"));
	}
	
	public static void addUserRating(User user, Movie movie, Rating rating) throws Exception {
		Map<Movie, Rating> ratings = USER_RATINGS.get(user);
		if(ratings == null) {
			ratings = new HashMap<Movie, Rating>();
			USER_RATINGS.put(user, ratings);
		}
		if(ratings.containsKey(movie)){
			throw new Exception("You have already rated this movie.");
		} else {
			ratings.put(movie, rating);
			movie.addStars(rating.getStars());
		}
	}
	
	public static void removeUserRating(User user, Movie movie) throws Exception {
		Map<Movie, Rating> ratings = USER_RATINGS.get(user);
		if(ratings != null) {
			Rating rating = ratings.remove(movie);
			if(rating == null) {
				throw new Exception("You haven't rated this movie");
			}
			movie.removeStars(rating.getStars());
		} else {
			throw new Exception("You haven't rated this movie");
		}
	}
	
	public static void updateUserRating(User user, Movie movie, Rating rating) throws Exception {
		removeUserRating(user, movie);
		addUserRating(user, movie, rating);
	}
	
	public static Collection<User> getUsers() {
		return USERS.values();
	}
	
	public static Collection<Movie> getMovies() {
		return MOVIES.values();
	}

	public static User getUserByName(String nickname) {
		return USERS.get(nickname);
	}
	
	public static User getUserByToken(String token) {
		return AUTHORIZED_USERS.get(token);
	}
	
	public static void addToken(String token, User user) {
		AUTHORIZED_USERS.put(token, user);
	}

	public static Movie getMovieById(String id) {
		return MOVIES.get(id);
	}

	public static void addUser(User user) {
		USERS.put(user.getNickName(), user);
	}
}
