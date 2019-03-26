package com.mis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MOVIE")
public class Movie 
{
	private static final long serialVersionUID = -3465813074586302847L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column
	private String movieTitle;
	@Column
	private String movieArtist;
	@Column
	private int year;
	@Column
	private String description;
	
	
	public Movie() {};
	
	public Movie(String movieTitle, String movieArtist, int year, String description) {
		this.movieTitle = movieTitle;
		this.movieArtist = movieArtist;
		this.year = year;
		this.description = description;
	}

	public Movie(int id, String movieTitle, String movieArtist, int year, String description) {
		this.id = id;
		this.movieTitle = movieTitle;
		this.movieArtist = movieArtist;
		this.year = year;
		this.description = description;
	}
	
	public Movie(String movieTitle) {
		super();
		this.movieTitle = movieTitle;
		System.out.println("Movie " + movieTitle + "has been created.");
	}
	/* getter and setter methods*/
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
		return "Movie [movieId=" + id + ", movieTitle=" + movieTitle + ", movieArtist=" + movieArtist + ", year="
				+ year + ", description=" + description + "]";
	}

}
