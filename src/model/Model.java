package model;

import java.util.ArrayList;

public class Model {
	private final ArrayList<Movie> movies;
	private ArrayList<User> users;

	public Model() {
		movies = new ArrayList<Movie>();
		users = new ArrayList<User>();
		addDummyMovies();
	}

	public ArrayList<Movie> getMovies() {
		return movies;
	}

	private void addDummyMovies() {
		Movie one = new Movie(1, "tt0137523", "Fight Club", "1999", 139, "David Fincher",
				"An insomniac office worker, looking for a way to change his life, crosses paths with a devil-may-care soap maker, forming an underground fight club that evolves into something much, much more...");
		Movie two = new Movie(2, "tt2713180", "Fury", "2014", 134, "David Ayer",
				"April, 1945. As the Allies make their final push in the European Theatre, a battle-hardened Army sergeant named Wardaddy commands a Sherman tank and his five-man crew on a deadly mission behind enemy lines. Outnumbered, out-gunned, and with a rookie soldier thrust into their platoon, Wardaddy and his men face overwhelming odds in their heroic attempts to strike at the heart of Nazi Germany.");
		Movie three = new Movie(3, "tt0111161", "The Shawshank Redemption", "1994", 142, "Frank Darabont",
				"Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.");
		Movie four = new Movie(4, "tt0468569", "The Dark Knight", "2008", 152, "Christopher Nolan",
				"When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, the caped crusader must come to terms with one of the greatest psychological tests of his ability to fight injustice.");
		Movie five = new Movie(5, "tt0372784", "Batman Begins", "2005", 140, "Christopher Nolan",
				"After training with his mentor, Batman begins his war on crime to free the crime-ridden Gotham City from corruption that the Scarecrow and the League of Shadows have cast upon it.");
		Movie six = new Movie(6, "tt1345836", "The Dark Knight Rises", "2012", 165, "Christopher Nolan",
				"Eight years after the Joker's reign of anarchy, the Dark Knight is forced to return from his imposed exile to save Gotham City from the brutal guerrilla terrorist Bane with the help of the enigmatic Catwoman.");
		movies.add(one);
		movies.add(two);
		movies.add(three);
		movies.add(four);
		movies.add(five);
		movies.add(six);

	}

	
	public ArrayList<User> getUsers() {
		return users;
	}

	

}
