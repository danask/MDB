package com.mis.dao;

import java.util.List;

import com.mis.model.Movie;

public interface MovieDAO {

	public void addMovie(Movie movie);

	public List<Movie> getAllMovies();

	public void deleteMovie(Integer movieId);

	public Movie updateMovie(Movie movie);

	public Movie getMovie(int movieid);
	
	public Movie getMovie(String movieTitle, String movieArtist);
}
