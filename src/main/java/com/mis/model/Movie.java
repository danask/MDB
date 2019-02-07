package com.mis.model;

public class Movie 
{
	private String movieId;
	private String movieTitle;
	private String movieArtist;
	private int year;
	private String description;
	
	public Movie(String movieTitle) {
		super();
		this.movieTitle = movieTitle;
		System.out.println("Movie " + movieTitle + "has been created.");
	}
	
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public String getMovieTitle() {
		return movieTitle;
	}
	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}
	public String getMovieArtist() {
		return movieArtist;
	}
	public void setMovieArtist(String movieArtist) {
		this.movieArtist = movieArtist;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieTitle=" + movieTitle + ", movieArtist=" + movieArtist + ", year="
				+ year + ", description=" + description + "]";
	}

}
