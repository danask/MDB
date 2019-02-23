package com.mis.service;

import java.util.List;

import com.mis.model.Movie;

public interface MovieService {
	
	public void addMovie(Movie movie);

	public List<Movie> getAllMovies();

	public void deleteMovie(Integer movieId);

	public Movie getMovie(int movieid);
	
	public Movie updateMovie(Movie movie);
}
