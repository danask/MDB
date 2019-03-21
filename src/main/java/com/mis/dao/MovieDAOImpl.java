package com.mis.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mis.model.Movie;
import com.mis.model.User;

@Repository
public class MovieDAOImpl implements MovieDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void addMovie(Movie movie) 
	{
		sessionFactory.getCurrentSession().saveOrUpdate(movie);
	}

	@SuppressWarnings("unchecked")
	public List<Movie> getAllMovies() 
	{
		return sessionFactory.getCurrentSession().createQuery("from Movie")
				.list();
	}

	@Override
	public void deleteMovie(Integer movieId) 
	{
		Movie movie = (Movie) sessionFactory.getCurrentSession().
											load(Movie.class, movieId);
		if (movie != null) {
			this.sessionFactory.getCurrentSession().delete(movie);
		}
	}

	public Movie getMovie(int movieid) {
		return (Movie) sessionFactory.getCurrentSession().get(
				Movie.class, movieid);
	}

//	public Movie getMovieByEmailPwd(String email, String pwd) {
//		
//		List<Movie> movies = new ArrayList<Movie>();
//		
//		movies = sessionFactory.getCurrentSession()
//			.createQuery("from Movie where email=? and password=?")
//			.setParameter(0, email)
//			.setParameter(1, pwd)
//			.list();
//
//		if (movies.size() > 0) 
//		{
//			return movies.get(0);
//		} 
//		else 
//		{
//			return null;
//		}
//	}
	
	@Override
	public Movie updateMovie(Movie movie) {
		sessionFactory.getCurrentSession().update(movie);
		return movie;
	}

	public Movie getMovie(String movieTitle, String movieArtist) 
	{
		List<Movie> movies = new ArrayList<Movie>();
		
		movies = sessionFactory.getCurrentSession()
			.createQuery("from Movie where movieTitle=? and movieArtist=?")
			.setParameter(0, movieTitle)
			.setParameter(1, movieArtist)
			.list();

		if (movies.size() > 0) 
		{
			return movies.get(0);
		} 
		else 
		{
			return null;
		}
	}
	
}