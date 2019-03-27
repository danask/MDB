package com.mis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mis.dao.MovieDAO;
import com.mis.model.Movie;

@Service
@Transactional
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieDAO movieDAO;

	@Override
	@Transactional
	public void addMovie(Movie movie) {
		movieDAO.addMovie(movie);
	}

	@Override
	@Transactional
	public List<Movie> getAllMovies() {
		return movieDAO.getAllMovies();
	}

	@Override
	@Transactional
	public void deleteMovie(Integer movieId) {
		movieDAO.deleteMovie(movieId);
	}

	public Movie getMovie(int id) {
		return movieDAO.getMovie(id);
	}
	
	public Movie updateMovie(Movie movie) {
		// TODO Auto-generated method stub
		return movieDAO.updateMovie(movie);
	}

	public void setMovieDAO(MovieDAO movieDAO) {
		this.movieDAO = movieDAO;
	}

	public List<Movie> getMovie(String movieTitle, String movieArtist) {
		return movieDAO.getMovie(movieTitle, movieArtist);
	}
	
	public Movie getMovieWithParams(String movieTitle, String movieArtist, int year) {
		return movieDAO.getMovieWithParams(movieTitle, movieArtist, year);
	}
}
