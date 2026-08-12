package sqa.lab.model;

public class Movie {

	private String title;

	private String cinemaType;

	public Movie(String title, String cinemaType) {
		this.title = title;
		this.cinemaType = cinemaType;
	}

	public String getTitle() {
		return title;
	}

	public String getCinemaType() {
		return cinemaType;
	}

}
