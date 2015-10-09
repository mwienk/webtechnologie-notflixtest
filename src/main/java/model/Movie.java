package model;


public class Movie {
	private int internFollowNumber;
	private String IMDBttNumber;
	private String title;
	private String publishDate;
	private int lengthInMinutes;
	private String director;
	private String description;
	private int totalVotes;
	private int totalStars;
	
	public Movie() {
	
	}

	public Movie(int internFollowNumber, String iMDBttNumber, String title, String publishDate, int lengthInMinutes,
			String director, String description) {
		super();
		this.internFollowNumber = internFollowNumber;
		this.IMDBttNumber = iMDBttNumber;
		this.title = title;
		this.publishDate = publishDate;
		this.lengthInMinutes = lengthInMinutes;
		this.director = director;
		this.description = description;
	}

	public int getInternFollowNumber() {
		return internFollowNumber;
	}

	public String getIMDBttNumber() {
		return IMDBttNumber;
	}

	public String getTitle() {
		return title;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public int getLengthInMinutes() {
		return lengthInMinutes;
	}

	public String getDirector() {
		return director;
	}

	public String getDescription() {
		return description;
	}

	public int getTotalVotes() {
		return totalVotes;
	}

	public void setTotalVotes(int totalVotes) {
		this.totalVotes = totalVotes;
	}

	public int getTotalStars() {
		return totalStars;
	}

	public void setTotalStars(int totalStars) {
		this.totalStars = totalStars;
	}

	public void addStars(int stars) {
		this.totalVotes++;
		this.totalStars += stars;
	}

	public void removeStars(int stars) {
		this.totalVotes--;
		this.totalStars -= stars;
	}

}
